package com.javen.service.serviceImpl;

import com.javen.dao.MessageBoardInfoDao;
import com.javen.model.MessageBoardInfo;
import com.javen.model.MessageBoardInfoExample;
import com.javen.service.MessageBoardInfoService;
import com.javen.util.PageBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author: 杜云章
 * @description:
 * @Date: 2019-06-11 12:50
 */
@Service("messageBoardInfoServiceImpl")
public class MessageBoardInfoServiceImpl implements MessageBoardInfoService {

    private static Logger log= LoggerFactory.getLogger(MessageBoardInfoServiceImpl.class);

    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private MessageBoardInfoDao messageBoardInfoDao;

    @Override
    @Transactional
    public String leavingMessage(Map<String, Object> map) {
        if(checkMessageInfo(map)){
            MessageBoardInfo messageBoardInfo = new MessageBoardInfo();
            messageBoardInfo.setMessageAccout((String) map.get("usrAccount"));
            messageBoardInfo.setMessageTittle((String) map.get("tittle"));
            messageBoardInfo.setMessageKey((String) map.get("key"));
            messageBoardInfo.setMessageContext((String) map.get("context"));
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            messageBoardInfo.setMessageDate(df.format(new Date()));
            messageBoardInfo.setIsActive(1);
            int result = messageBoardInfoDao.insert(messageBoardInfo);
            if(result == 0){
                map.put("errorMessage","插入失败");
                log.error("插入失败");
            }else {
                map.put("errorMessage","0");
                log.info("插入成功");
            }
        }
        return (String) map.get("errorMessage");
    }

    /**
     * @Author: 杜云章
     * @description: 校验留言信息是否缺失
     * @parm: map[title,key,context]
     * @return: boolean true 表示校验成功 false表示校验失败
     * @Date: 2019/6/11 - 13:40
     */
    private boolean checkMessageInfo(Map<String, Object> map) {
        String tittle = (String) map.get("tittle");
        if(tittle == null || "".equals(tittle)){
            map.put("errorMessage","标题为空");
            log.error("标题为空");
            return false;
        }
        String key = (String) map.get("key");
        if(key == null || "".equals(key)){
            map.put("errorMessage","关键字为空");
            log.error("关键字为空");
            return false;
        }
        String context = (String) map.get("context");
        if(key == null || "".equals(key)){
            map.put("errorMessage","内容为空");
            log.error("内容为空");
            return false;
        }
        Map<Object, Object> loginInfo = redisTemplate.opsForHash().entries("loginInfo");
        if(loginInfo.isEmpty() || loginInfo == null){
            map.put("errorMessage","用户信息为空");
            log.error("用户信息为空");
            return false;
        }
        else {
            map.put("usrAccount",loginInfo.get("usrAccount"));
        }
        return true;
    }

    @Override
    public PageBean<MessageBoardInfo> listMessageBoardInfoByPage(Map<String, Object> map) {
        // 1.创建Eaxmple对象用户sql筛选条件组合
        MessageBoardInfoExample mbie = new MessageBoardInfoExample();
        MessageBoardInfoExample.Criteria criteria = mbie.createCriteria();
        // 2.根据传过来的的参数来判断是否有条件查询
        String tittle = (String) map.get("tittle");
        if(tittle != null && tittle != ""){
            criteria.andMessageTittleEqualTo(tittle);
            log.info("按标题条件查询：tittle: "+tittle);
        }
        String key = (String) map.get("key");
        if(key != null && key!=""){
            criteria.andMessageKeyEqualTo(key);
            log.info("按关键字条件查询：key: "+key);
        }
        String account = (String) map.get("account");
        if(account != null && account!=""){
            criteria.andMessageAccoutEqualTo(account);
            log.info("按用户账号条件查询：account: "+account);
        }
        String context = (String) map.get("context");
        if(context != null && context!=""){
            criteria.andMessageContextLike("%"+context+"%");
            log.info("按内容模糊查询：context: "+context);
        }
        // 3.根据传过来的蚕食来检验是否 分页 和 排序
        // isPage标志位用于判断是否分页：
        //                          如果分页，则需要根据日期递减排序，
        //                          如果不分页，则需要根据日期递增排序（前端加载原因，工作量比较大暂时不想改）
        boolean isPage = true;
        Object pageNumO = map.get("pageNum");
        Object pageSizeO = map.get("pageSize");
        if(pageNumO == null || "".equals(pageNumO)){
            log.error("页面编号为空");
            isPage = false;
        }
        if(pageSizeO == null|| "".equals(pageSizeO)){
            log.error("页面大小为空");
            isPage = false;
        }
        if(isPage){
            Integer pageNum = Integer.parseInt(String.valueOf(map.get("pageNum")));
            Integer pageSize = Integer.parseInt(String.valueOf(map.get("pageSize")));
            Integer startNum = (pageNum-1)*pageSize;
            log.info("分页查询：offset: " + startNum + ", limit: " + pageSize);
            mbie.setLimit(pageSize);
            mbie.setOffset(startNum.longValue());
            mbie.setOrderByClause("message_date DESC");
        } else {
            mbie.setOrderByClause("message_date");
        }
        // 4.查询结果前先查询count，若count = 0，则不做第二次详细查询
        long count = messageBoardInfoDao.countByExample(mbie);
        List<MessageBoardInfo> searchResult = null;
        if(count > 0){
            searchResult = messageBoardInfoDao.selectByExample(mbie);
        }
        // 5.将查询结果封装到pageBean中
        PageBean<MessageBoardInfo> pageBean = new PageBean<MessageBoardInfo>(searchResult, (int) count);
        return pageBean;
    }

    @Override
    @Transactional
    public String deleteMessages(List<Integer> list) {
        MessageBoardInfoExample mbie = new MessageBoardInfoExample();
        mbie.createCriteria().andMessageInfoIdIn(list);
        int result = messageBoardInfoDao.deleteByExample(mbie);
        if(0 == result){
            log.debug("删除失败");
            return "删除失败";
        }
        log.info("删除成功");
        return "0";
    }

}
