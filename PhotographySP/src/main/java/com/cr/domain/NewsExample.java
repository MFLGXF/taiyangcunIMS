package com.cr.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class NewsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NewsExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNewsNameIsNull() {
            addCriterion("news_name is null");
            return (Criteria) this;
        }

        public Criteria andNewsNameIsNotNull() {
            addCriterion("news_name is not null");
            return (Criteria) this;
        }

        public Criteria andNewsNameEqualTo(String value) {
            addCriterion("news_name =", value, "newsName");
            return (Criteria) this;
        }

        public Criteria andNewsNameNotEqualTo(String value) {
            addCriterion("news_name <>", value, "newsName");
            return (Criteria) this;
        }

        public Criteria andNewsNameGreaterThan(String value) {
            addCriterion("news_name >", value, "newsName");
            return (Criteria) this;
        }

        public Criteria andNewsNameGreaterThanOrEqualTo(String value) {
            addCriterion("news_name >=", value, "newsName");
            return (Criteria) this;
        }

        public Criteria andNewsNameLessThan(String value) {
            addCriterion("news_name <", value, "newsName");
            return (Criteria) this;
        }

        public Criteria andNewsNameLessThanOrEqualTo(String value) {
            addCriterion("news_name <=", value, "newsName");
            return (Criteria) this;
        }

        public Criteria andNewsNameLike(String value) {
            addCriterion("news_name like", value, "newsName");
            return (Criteria) this;
        }

        public Criteria andNewsNameNotLike(String value) {
            addCriterion("news_name not like", value, "newsName");
            return (Criteria) this;
        }

        public Criteria andNewsNameIn(List<String> values) {
            addCriterion("news_name in", values, "newsName");
            return (Criteria) this;
        }

        public Criteria andNewsNameNotIn(List<String> values) {
            addCriterion("news_name not in", values, "newsName");
            return (Criteria) this;
        }

        public Criteria andNewsNameBetween(String value1, String value2) {
            addCriterion("news_name between", value1, value2, "newsName");
            return (Criteria) this;
        }

        public Criteria andNewsNameNotBetween(String value1, String value2) {
            addCriterion("news_name not between", value1, value2, "newsName");
            return (Criteria) this;
        }

        public Criteria andNewsMessageIsNull() {
            addCriterion("news_message is null");
            return (Criteria) this;
        }

        public Criteria andNewsMessageIsNotNull() {
            addCriterion("news_message is not null");
            return (Criteria) this;
        }

        public Criteria andNewsMessageEqualTo(String value) {
            addCriterion("news_message =", value, "newsMessage");
            return (Criteria) this;
        }

        public Criteria andNewsMessageNotEqualTo(String value) {
            addCriterion("news_message <>", value, "newsMessage");
            return (Criteria) this;
        }

        public Criteria andNewsMessageGreaterThan(String value) {
            addCriterion("news_message >", value, "newsMessage");
            return (Criteria) this;
        }

        public Criteria andNewsMessageGreaterThanOrEqualTo(String value) {
            addCriterion("news_message >=", value, "newsMessage");
            return (Criteria) this;
        }

        public Criteria andNewsMessageLessThan(String value) {
            addCriterion("news_message <", value, "newsMessage");
            return (Criteria) this;
        }

        public Criteria andNewsMessageLessThanOrEqualTo(String value) {
            addCriterion("news_message <=", value, "newsMessage");
            return (Criteria) this;
        }

        public Criteria andNewsMessageLike(String value) {
            addCriterion("news_message like", value, "newsMessage");
            return (Criteria) this;
        }

        public Criteria andNewsMessageNotLike(String value) {
            addCriterion("news_message not like", value, "newsMessage");
            return (Criteria) this;
        }

        public Criteria andNewsMessageIn(List<String> values) {
            addCriterion("news_message in", values, "newsMessage");
            return (Criteria) this;
        }

        public Criteria andNewsMessageNotIn(List<String> values) {
            addCriterion("news_message not in", values, "newsMessage");
            return (Criteria) this;
        }

        public Criteria andNewsMessageBetween(String value1, String value2) {
            addCriterion("news_message between", value1, value2, "newsMessage");
            return (Criteria) this;
        }

        public Criteria andNewsMessageNotBetween(String value1, String value2) {
            addCriterion("news_message not between", value1, value2, "newsMessage");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterionForJDBCDate("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterionForJDBCDate("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }
    }

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