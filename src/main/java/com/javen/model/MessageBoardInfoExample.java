package com.javen.model;

import java.util.ArrayList;
import java.util.List;

public class MessageBoardInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public MessageBoardInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andMessageInfoIdIsNull() {
            addCriterion("message_info_id is null");
            return (Criteria) this;
        }

        public Criteria andMessageInfoIdIsNotNull() {
            addCriterion("message_info_id is not null");
            return (Criteria) this;
        }

        public Criteria andMessageInfoIdEqualTo(Integer value) {
            addCriterion("message_info_id =", value, "messageInfoId");
            return (Criteria) this;
        }

        public Criteria andMessageInfoIdNotEqualTo(Integer value) {
            addCriterion("message_info_id <>", value, "messageInfoId");
            return (Criteria) this;
        }

        public Criteria andMessageInfoIdGreaterThan(Integer value) {
            addCriterion("message_info_id >", value, "messageInfoId");
            return (Criteria) this;
        }

        public Criteria andMessageInfoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("message_info_id >=", value, "messageInfoId");
            return (Criteria) this;
        }

        public Criteria andMessageInfoIdLessThan(Integer value) {
            addCriterion("message_info_id <", value, "messageInfoId");
            return (Criteria) this;
        }

        public Criteria andMessageInfoIdLessThanOrEqualTo(Integer value) {
            addCriterion("message_info_id <=", value, "messageInfoId");
            return (Criteria) this;
        }

        public Criteria andMessageInfoIdIn(List<Integer> values) {
            addCriterion("message_info_id in", values, "messageInfoId");
            return (Criteria) this;
        }

        public Criteria andMessageInfoIdNotIn(List<Integer> values) {
            addCriterion("message_info_id not in", values, "messageInfoId");
            return (Criteria) this;
        }

        public Criteria andMessageInfoIdBetween(Integer value1, Integer value2) {
            addCriterion("message_info_id between", value1, value2, "messageInfoId");
            return (Criteria) this;
        }

        public Criteria andMessageInfoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("message_info_id not between", value1, value2, "messageInfoId");
            return (Criteria) this;
        }

        public Criteria andMessageTittleIsNull() {
            addCriterion("Message_tittle is null");
            return (Criteria) this;
        }

        public Criteria andMessageTittleIsNotNull() {
            addCriterion("Message_tittle is not null");
            return (Criteria) this;
        }

        public Criteria andMessageTittleEqualTo(String value) {
            addCriterion("Message_tittle =", value, "messageTittle");
            return (Criteria) this;
        }

        public Criteria andMessageTittleNotEqualTo(String value) {
            addCriterion("Message_tittle <>", value, "messageTittle");
            return (Criteria) this;
        }

        public Criteria andMessageTittleGreaterThan(String value) {
            addCriterion("Message_tittle >", value, "messageTittle");
            return (Criteria) this;
        }

        public Criteria andMessageTittleGreaterThanOrEqualTo(String value) {
            addCriterion("Message_tittle >=", value, "messageTittle");
            return (Criteria) this;
        }

        public Criteria andMessageTittleLessThan(String value) {
            addCriterion("Message_tittle <", value, "messageTittle");
            return (Criteria) this;
        }

        public Criteria andMessageTittleLessThanOrEqualTo(String value) {
            addCriterion("Message_tittle <=", value, "messageTittle");
            return (Criteria) this;
        }

        public Criteria andMessageTittleLike(String value) {
            addCriterion("Message_tittle like", value, "messageTittle");
            return (Criteria) this;
        }

        public Criteria andMessageTittleNotLike(String value) {
            addCriterion("Message_tittle not like", value, "messageTittle");
            return (Criteria) this;
        }

        public Criteria andMessageTittleIn(List<String> values) {
            addCriterion("Message_tittle in", values, "messageTittle");
            return (Criteria) this;
        }

        public Criteria andMessageTittleNotIn(List<String> values) {
            addCriterion("Message_tittle not in", values, "messageTittle");
            return (Criteria) this;
        }

        public Criteria andMessageTittleBetween(String value1, String value2) {
            addCriterion("Message_tittle between", value1, value2, "messageTittle");
            return (Criteria) this;
        }

        public Criteria andMessageTittleNotBetween(String value1, String value2) {
            addCriterion("Message_tittle not between", value1, value2, "messageTittle");
            return (Criteria) this;
        }

        public Criteria andMessageDateIsNull() {
            addCriterion("message_date is null");
            return (Criteria) this;
        }

        public Criteria andMessageDateIsNotNull() {
            addCriterion("message_date is not null");
            return (Criteria) this;
        }

        public Criteria andMessageDateEqualTo(String value) {
            addCriterion("message_date =", value, "messageDate");
            return (Criteria) this;
        }

        public Criteria andMessageDateNotEqualTo(String value) {
            addCriterion("message_date <>", value, "messageDate");
            return (Criteria) this;
        }

        public Criteria andMessageDateGreaterThan(String value) {
            addCriterion("message_date >", value, "messageDate");
            return (Criteria) this;
        }

        public Criteria andMessageDateGreaterThanOrEqualTo(String value) {
            addCriterion("message_date >=", value, "messageDate");
            return (Criteria) this;
        }

        public Criteria andMessageDateLessThan(String value) {
            addCriterion("message_date <", value, "messageDate");
            return (Criteria) this;
        }

        public Criteria andMessageDateLessThanOrEqualTo(String value) {
            addCriterion("message_date <=", value, "messageDate");
            return (Criteria) this;
        }

        public Criteria andMessageDateLike(String value) {
            addCriterion("message_date like", value, "messageDate");
            return (Criteria) this;
        }

        public Criteria andMessageDateNotLike(String value) {
            addCriterion("message_date not like", value, "messageDate");
            return (Criteria) this;
        }

        public Criteria andMessageDateIn(List<String> values) {
            addCriterion("message_date in", values, "messageDate");
            return (Criteria) this;
        }

        public Criteria andMessageDateNotIn(List<String> values) {
            addCriterion("message_date not in", values, "messageDate");
            return (Criteria) this;
        }

        public Criteria andMessageDateBetween(String value1, String value2) {
            addCriterion("message_date between", value1, value2, "messageDate");
            return (Criteria) this;
        }

        public Criteria andMessageDateNotBetween(String value1, String value2) {
            addCriterion("message_date not between", value1, value2, "messageDate");
            return (Criteria) this;
        }

        public Criteria andMessageAccoutIsNull() {
            addCriterion("Message_accout is null");
            return (Criteria) this;
        }

        public Criteria andMessageAccoutIsNotNull() {
            addCriterion("Message_accout is not null");
            return (Criteria) this;
        }

        public Criteria andMessageAccoutEqualTo(String value) {
            addCriterion("Message_accout =", value, "messageAccout");
            return (Criteria) this;
        }

        public Criteria andMessageAccoutNotEqualTo(String value) {
            addCriterion("Message_accout <>", value, "messageAccout");
            return (Criteria) this;
        }

        public Criteria andMessageAccoutGreaterThan(String value) {
            addCriterion("Message_accout >", value, "messageAccout");
            return (Criteria) this;
        }

        public Criteria andMessageAccoutGreaterThanOrEqualTo(String value) {
            addCriterion("Message_accout >=", value, "messageAccout");
            return (Criteria) this;
        }

        public Criteria andMessageAccoutLessThan(String value) {
            addCriterion("Message_accout <", value, "messageAccout");
            return (Criteria) this;
        }

        public Criteria andMessageAccoutLessThanOrEqualTo(String value) {
            addCriterion("Message_accout <=", value, "messageAccout");
            return (Criteria) this;
        }

        public Criteria andMessageAccoutLike(String value) {
            addCriterion("Message_accout like", value, "messageAccout");
            return (Criteria) this;
        }

        public Criteria andMessageAccoutNotLike(String value) {
            addCriterion("Message_accout not like", value, "messageAccout");
            return (Criteria) this;
        }

        public Criteria andMessageAccoutIn(List<String> values) {
            addCriterion("Message_accout in", values, "messageAccout");
            return (Criteria) this;
        }

        public Criteria andMessageAccoutNotIn(List<String> values) {
            addCriterion("Message_accout not in", values, "messageAccout");
            return (Criteria) this;
        }

        public Criteria andMessageAccoutBetween(String value1, String value2) {
            addCriterion("Message_accout between", value1, value2, "messageAccout");
            return (Criteria) this;
        }

        public Criteria andMessageAccoutNotBetween(String value1, String value2) {
            addCriterion("Message_accout not between", value1, value2, "messageAccout");
            return (Criteria) this;
        }

        public Criteria andMessageContextIsNull() {
            addCriterion("Message_context is null");
            return (Criteria) this;
        }

        public Criteria andMessageContextIsNotNull() {
            addCriterion("Message_context is not null");
            return (Criteria) this;
        }

        public Criteria andMessageContextEqualTo(String value) {
            addCriterion("Message_context =", value, "messageContext");
            return (Criteria) this;
        }

        public Criteria andMessageContextNotEqualTo(String value) {
            addCriterion("Message_context <>", value, "messageContext");
            return (Criteria) this;
        }

        public Criteria andMessageContextGreaterThan(String value) {
            addCriterion("Message_context >", value, "messageContext");
            return (Criteria) this;
        }

        public Criteria andMessageContextGreaterThanOrEqualTo(String value) {
            addCriterion("Message_context >=", value, "messageContext");
            return (Criteria) this;
        }

        public Criteria andMessageContextLessThan(String value) {
            addCriterion("Message_context <", value, "messageContext");
            return (Criteria) this;
        }

        public Criteria andMessageContextLessThanOrEqualTo(String value) {
            addCriterion("Message_context <=", value, "messageContext");
            return (Criteria) this;
        }

        public Criteria andMessageContextLike(String value) {
            addCriterion("Message_context like", value, "messageContext");
            return (Criteria) this;
        }

        public Criteria andMessageContextNotLike(String value) {
            addCriterion("Message_context not like", value, "messageContext");
            return (Criteria) this;
        }

        public Criteria andMessageContextIn(List<String> values) {
            addCriterion("Message_context in", values, "messageContext");
            return (Criteria) this;
        }

        public Criteria andMessageContextNotIn(List<String> values) {
            addCriterion("Message_context not in", values, "messageContext");
            return (Criteria) this;
        }

        public Criteria andMessageContextBetween(String value1, String value2) {
            addCriterion("Message_context between", value1, value2, "messageContext");
            return (Criteria) this;
        }

        public Criteria andMessageContextNotBetween(String value1, String value2) {
            addCriterion("Message_context not between", value1, value2, "messageContext");
            return (Criteria) this;
        }

        public Criteria andMessageKeyIsNull() {
            addCriterion("message_key is null");
            return (Criteria) this;
        }

        public Criteria andMessageKeyIsNotNull() {
            addCriterion("message_key is not null");
            return (Criteria) this;
        }

        public Criteria andMessageKeyEqualTo(String value) {
            addCriterion("message_key =", value, "messageKey");
            return (Criteria) this;
        }

        public Criteria andMessageKeyNotEqualTo(String value) {
            addCriterion("message_key <>", value, "messageKey");
            return (Criteria) this;
        }

        public Criteria andMessageKeyGreaterThan(String value) {
            addCriterion("message_key >", value, "messageKey");
            return (Criteria) this;
        }

        public Criteria andMessageKeyGreaterThanOrEqualTo(String value) {
            addCriterion("message_key >=", value, "messageKey");
            return (Criteria) this;
        }

        public Criteria andMessageKeyLessThan(String value) {
            addCriterion("message_key <", value, "messageKey");
            return (Criteria) this;
        }

        public Criteria andMessageKeyLessThanOrEqualTo(String value) {
            addCriterion("message_key <=", value, "messageKey");
            return (Criteria) this;
        }

        public Criteria andMessageKeyLike(String value) {
            addCriterion("message_key like", value, "messageKey");
            return (Criteria) this;
        }

        public Criteria andMessageKeyNotLike(String value) {
            addCriterion("message_key not like", value, "messageKey");
            return (Criteria) this;
        }

        public Criteria andMessageKeyIn(List<String> values) {
            addCriterion("message_key in", values, "messageKey");
            return (Criteria) this;
        }

        public Criteria andMessageKeyNotIn(List<String> values) {
            addCriterion("message_key not in", values, "messageKey");
            return (Criteria) this;
        }

        public Criteria andMessageKeyBetween(String value1, String value2) {
            addCriterion("message_key between", value1, value2, "messageKey");
            return (Criteria) this;
        }

        public Criteria andMessageKeyNotBetween(String value1, String value2) {
            addCriterion("message_key not between", value1, value2, "messageKey");
            return (Criteria) this;
        }

        public Criteria andIsActiveIsNull() {
            addCriterion("is_active is null");
            return (Criteria) this;
        }

        public Criteria andIsActiveIsNotNull() {
            addCriterion("is_active is not null");
            return (Criteria) this;
        }

        public Criteria andIsActiveEqualTo(Integer value) {
            addCriterion("is_active =", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveNotEqualTo(Integer value) {
            addCriterion("is_active <>", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveGreaterThan(Integer value) {
            addCriterion("is_active >", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_active >=", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveLessThan(Integer value) {
            addCriterion("is_active <", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveLessThanOrEqualTo(Integer value) {
            addCriterion("is_active <=", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveIn(List<Integer> values) {
            addCriterion("is_active in", values, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveNotIn(List<Integer> values) {
            addCriterion("is_active not in", values, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveBetween(Integer value1, Integer value2) {
            addCriterion("is_active between", value1, value2, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveNotBetween(Integer value1, Integer value2) {
            addCriterion("is_active not between", value1, value2, "isActive");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}