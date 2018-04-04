package com.fwx.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class WorkerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkerExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andWorkerNameIsNull() {
            addCriterion("worker_name is null");
            return (Criteria) this;
        }

        public Criteria andWorkerNameIsNotNull() {
            addCriterion("worker_name is not null");
            return (Criteria) this;
        }

        public Criteria andWorkerNameEqualTo(String value) {
            addCriterion("worker_name =", value, "workerName");
            return (Criteria) this;
        }

        public Criteria andWorkerNameNotEqualTo(String value) {
            addCriterion("worker_name <>", value, "workerName");
            return (Criteria) this;
        }

        public Criteria andWorkerNameGreaterThan(String value) {
            addCriterion("worker_name >", value, "workerName");
            return (Criteria) this;
        }

        public Criteria andWorkerNameGreaterThanOrEqualTo(String value) {
            addCriterion("worker_name >=", value, "workerName");
            return (Criteria) this;
        }

        public Criteria andWorkerNameLessThan(String value) {
            addCriterion("worker_name <", value, "workerName");
            return (Criteria) this;
        }

        public Criteria andWorkerNameLessThanOrEqualTo(String value) {
            addCriterion("worker_name <=", value, "workerName");
            return (Criteria) this;
        }

        public Criteria andWorkerNameLike(String value) {
            addCriterion("worker_name like", value, "workerName");
            return (Criteria) this;
        }

        public Criteria andWorkerNameNotLike(String value) {
            addCriterion("worker_name not like", value, "workerName");
            return (Criteria) this;
        }

        public Criteria andWorkerNameIn(List<String> values) {
            addCriterion("worker_name in", values, "workerName");
            return (Criteria) this;
        }

        public Criteria andWorkerNameNotIn(List<String> values) {
            addCriterion("worker_name not in", values, "workerName");
            return (Criteria) this;
        }

        public Criteria andWorkerNameBetween(String value1, String value2) {
            addCriterion("worker_name between", value1, value2, "workerName");
            return (Criteria) this;
        }

        public Criteria andWorkerNameNotBetween(String value1, String value2) {
            addCriterion("worker_name not between", value1, value2, "workerName");
            return (Criteria) this;
        }

        public Criteria andWorkerIdcardIsNull() {
            addCriterion("worker_idcard is null");
            return (Criteria) this;
        }

        public Criteria andWorkerIdcardIsNotNull() {
            addCriterion("worker_idcard is not null");
            return (Criteria) this;
        }

        public Criteria andWorkerIdcardEqualTo(String value) {
            addCriterion("worker_idcard =", value, "workerIdcard");
            return (Criteria) this;
        }

        public Criteria andWorkerIdcardNotEqualTo(String value) {
            addCriterion("worker_idcard <>", value, "workerIdcard");
            return (Criteria) this;
        }

        public Criteria andWorkerIdcardGreaterThan(String value) {
            addCriterion("worker_idcard >", value, "workerIdcard");
            return (Criteria) this;
        }

        public Criteria andWorkerIdcardGreaterThanOrEqualTo(String value) {
            addCriterion("worker_idcard >=", value, "workerIdcard");
            return (Criteria) this;
        }

        public Criteria andWorkerIdcardLessThan(String value) {
            addCriterion("worker_idcard <", value, "workerIdcard");
            return (Criteria) this;
        }

        public Criteria andWorkerIdcardLessThanOrEqualTo(String value) {
            addCriterion("worker_idcard <=", value, "workerIdcard");
            return (Criteria) this;
        }

        public Criteria andWorkerIdcardLike(String value) {
            addCriterion("worker_idcard like", value, "workerIdcard");
            return (Criteria) this;
        }

        public Criteria andWorkerIdcardNotLike(String value) {
            addCriterion("worker_idcard not like", value, "workerIdcard");
            return (Criteria) this;
        }

        public Criteria andWorkerIdcardIn(List<String> values) {
            addCriterion("worker_idcard in", values, "workerIdcard");
            return (Criteria) this;
        }

        public Criteria andWorkerIdcardNotIn(List<String> values) {
            addCriterion("worker_idcard not in", values, "workerIdcard");
            return (Criteria) this;
        }

        public Criteria andWorkerIdcardBetween(String value1, String value2) {
            addCriterion("worker_idcard between", value1, value2, "workerIdcard");
            return (Criteria) this;
        }

        public Criteria andWorkerIdcardNotBetween(String value1, String value2) {
            addCriterion("worker_idcard not between", value1, value2, "workerIdcard");
            return (Criteria) this;
        }

        public Criteria andWorkerPostIsNull() {
            addCriterion("worker_post is null");
            return (Criteria) this;
        }

        public Criteria andWorkerPostIsNotNull() {
            addCriterion("worker_post is not null");
            return (Criteria) this;
        }

        public Criteria andWorkerPostEqualTo(String value) {
            addCriterion("worker_post =", value, "workerPost");
            return (Criteria) this;
        }

        public Criteria andWorkerPostNotEqualTo(String value) {
            addCriterion("worker_post <>", value, "workerPost");
            return (Criteria) this;
        }

        public Criteria andWorkerPostGreaterThan(String value) {
            addCriterion("worker_post >", value, "workerPost");
            return (Criteria) this;
        }

        public Criteria andWorkerPostGreaterThanOrEqualTo(String value) {
            addCriterion("worker_post >=", value, "workerPost");
            return (Criteria) this;
        }

        public Criteria andWorkerPostLessThan(String value) {
            addCriterion("worker_post <", value, "workerPost");
            return (Criteria) this;
        }

        public Criteria andWorkerPostLessThanOrEqualTo(String value) {
            addCriterion("worker_post <=", value, "workerPost");
            return (Criteria) this;
        }

        public Criteria andWorkerPostLike(String value) {
            addCriterion("worker_post like", value, "workerPost");
            return (Criteria) this;
        }

        public Criteria andWorkerPostNotLike(String value) {
            addCriterion("worker_post not like", value, "workerPost");
            return (Criteria) this;
        }

        public Criteria andWorkerPostIn(List<String> values) {
            addCriterion("worker_post in", values, "workerPost");
            return (Criteria) this;
        }

        public Criteria andWorkerPostNotIn(List<String> values) {
            addCriterion("worker_post not in", values, "workerPost");
            return (Criteria) this;
        }

        public Criteria andWorkerPostBetween(String value1, String value2) {
            addCriterion("worker_post between", value1, value2, "workerPost");
            return (Criteria) this;
        }

        public Criteria andWorkerPostNotBetween(String value1, String value2) {
            addCriterion("worker_post not between", value1, value2, "workerPost");
            return (Criteria) this;
        }

        public Criteria andWorkerPhoneIsNull() {
            addCriterion("worker_phone is null");
            return (Criteria) this;
        }

        public Criteria andWorkerPhoneIsNotNull() {
            addCriterion("worker_phone is not null");
            return (Criteria) this;
        }

        public Criteria andWorkerPhoneEqualTo(String value) {
            addCriterion("worker_phone =", value, "workerPhone");
            return (Criteria) this;
        }

        public Criteria andWorkerPhoneNotEqualTo(String value) {
            addCriterion("worker_phone <>", value, "workerPhone");
            return (Criteria) this;
        }

        public Criteria andWorkerPhoneGreaterThan(String value) {
            addCriterion("worker_phone >", value, "workerPhone");
            return (Criteria) this;
        }

        public Criteria andWorkerPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("worker_phone >=", value, "workerPhone");
            return (Criteria) this;
        }

        public Criteria andWorkerPhoneLessThan(String value) {
            addCriterion("worker_phone <", value, "workerPhone");
            return (Criteria) this;
        }

        public Criteria andWorkerPhoneLessThanOrEqualTo(String value) {
            addCriterion("worker_phone <=", value, "workerPhone");
            return (Criteria) this;
        }

        public Criteria andWorkerPhoneLike(String value) {
            addCriterion("worker_phone like", value, "workerPhone");
            return (Criteria) this;
        }

        public Criteria andWorkerPhoneNotLike(String value) {
            addCriterion("worker_phone not like", value, "workerPhone");
            return (Criteria) this;
        }

        public Criteria andWorkerPhoneIn(List<String> values) {
            addCriterion("worker_phone in", values, "workerPhone");
            return (Criteria) this;
        }

        public Criteria andWorkerPhoneNotIn(List<String> values) {
            addCriterion("worker_phone not in", values, "workerPhone");
            return (Criteria) this;
        }

        public Criteria andWorkerPhoneBetween(String value1, String value2) {
            addCriterion("worker_phone between", value1, value2, "workerPhone");
            return (Criteria) this;
        }

        public Criteria andWorkerPhoneNotBetween(String value1, String value2) {
            addCriterion("worker_phone not between", value1, value2, "workerPhone");
            return (Criteria) this;
        }

        public Criteria andJoinTimeIsNull() {
            addCriterion("join_time is null");
            return (Criteria) this;
        }

        public Criteria andJoinTimeIsNotNull() {
            addCriterion("join_time is not null");
            return (Criteria) this;
        }

        public Criteria andJoinTimeEqualTo(Date value) {
            addCriterionForJDBCDate("join_time =", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("join_time <>", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("join_time >", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("join_time >=", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeLessThan(Date value) {
            addCriterionForJDBCDate("join_time <", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("join_time <=", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeIn(List<Date> values) {
            addCriterionForJDBCDate("join_time in", values, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("join_time not in", values, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("join_time between", value1, value2, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("join_time not between", value1, value2, "joinTime");
            return (Criteria) this;
        }

        public Criteria andWagesIsNull() {
            addCriterion("wages is null");
            return (Criteria) this;
        }

        public Criteria andWagesIsNotNull() {
            addCriterion("wages is not null");
            return (Criteria) this;
        }

        public Criteria andWagesEqualTo(String value) {
            addCriterion("wages =", value, "wages");
            return (Criteria) this;
        }

        public Criteria andWagesNotEqualTo(String value) {
            addCriterion("wages <>", value, "wages");
            return (Criteria) this;
        }

        public Criteria andWagesGreaterThan(String value) {
            addCriterion("wages >", value, "wages");
            return (Criteria) this;
        }

        public Criteria andWagesGreaterThanOrEqualTo(String value) {
            addCriterion("wages >=", value, "wages");
            return (Criteria) this;
        }

        public Criteria andWagesLessThan(String value) {
            addCriterion("wages <", value, "wages");
            return (Criteria) this;
        }

        public Criteria andWagesLessThanOrEqualTo(String value) {
            addCriterion("wages <=", value, "wages");
            return (Criteria) this;
        }

        public Criteria andWagesLike(String value) {
            addCriterion("wages like", value, "wages");
            return (Criteria) this;
        }

        public Criteria andWagesNotLike(String value) {
            addCriterion("wages not like", value, "wages");
            return (Criteria) this;
        }

        public Criteria andWagesIn(List<String> values) {
            addCriterion("wages in", values, "wages");
            return (Criteria) this;
        }

        public Criteria andWagesNotIn(List<String> values) {
            addCriterion("wages not in", values, "wages");
            return (Criteria) this;
        }

        public Criteria andWagesBetween(String value1, String value2) {
            addCriterion("wages between", value1, value2, "wages");
            return (Criteria) this;
        }

        public Criteria andWagesNotBetween(String value1, String value2) {
            addCriterion("wages not between", value1, value2, "wages");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNull() {
            addCriterion("del_flag is null");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNotNull() {
            addCriterion("del_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDelFlagEqualTo(String value) {
            addCriterion("del_flag =", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotEqualTo(String value) {
            addCriterion("del_flag <>", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThan(String value) {
            addCriterion("del_flag >", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThanOrEqualTo(String value) {
            addCriterion("del_flag >=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThan(String value) {
            addCriterion("del_flag <", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThanOrEqualTo(String value) {
            addCriterion("del_flag <=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLike(String value) {
            addCriterion("del_flag like", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotLike(String value) {
            addCriterion("del_flag not like", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagIn(List<String> values) {
            addCriterion("del_flag in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotIn(List<String> values) {
            addCriterion("del_flag not in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagBetween(String value1, String value2) {
            addCriterion("del_flag between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotBetween(String value1, String value2) {
            addCriterion("del_flag not between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andAvaFlagIsNull() {
            addCriterion("ava_flag is null");
            return (Criteria) this;
        }

        public Criteria andAvaFlagIsNotNull() {
            addCriterion("ava_flag is not null");
            return (Criteria) this;
        }

        public Criteria andAvaFlagEqualTo(String value) {
            addCriterion("ava_flag =", value, "avaFlag");
            return (Criteria) this;
        }

        public Criteria andAvaFlagNotEqualTo(String value) {
            addCriterion("ava_flag <>", value, "avaFlag");
            return (Criteria) this;
        }

        public Criteria andAvaFlagGreaterThan(String value) {
            addCriterion("ava_flag >", value, "avaFlag");
            return (Criteria) this;
        }

        public Criteria andAvaFlagGreaterThanOrEqualTo(String value) {
            addCriterion("ava_flag >=", value, "avaFlag");
            return (Criteria) this;
        }

        public Criteria andAvaFlagLessThan(String value) {
            addCriterion("ava_flag <", value, "avaFlag");
            return (Criteria) this;
        }

        public Criteria andAvaFlagLessThanOrEqualTo(String value) {
            addCriterion("ava_flag <=", value, "avaFlag");
            return (Criteria) this;
        }

        public Criteria andAvaFlagLike(String value) {
            addCriterion("ava_flag like", value, "avaFlag");
            return (Criteria) this;
        }

        public Criteria andAvaFlagNotLike(String value) {
            addCriterion("ava_flag not like", value, "avaFlag");
            return (Criteria) this;
        }

        public Criteria andAvaFlagIn(List<String> values) {
            addCriterion("ava_flag in", values, "avaFlag");
            return (Criteria) this;
        }

        public Criteria andAvaFlagNotIn(List<String> values) {
            addCriterion("ava_flag not in", values, "avaFlag");
            return (Criteria) this;
        }

        public Criteria andAvaFlagBetween(String value1, String value2) {
            addCriterion("ava_flag between", value1, value2, "avaFlag");
            return (Criteria) this;
        }

        public Criteria andAvaFlagNotBetween(String value1, String value2) {
            addCriterion("ava_flag not between", value1, value2, "avaFlag");
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

        public Criteria andWorkerBankCardIsNull() {
            addCriterion("worker_bank_card is null");
            return (Criteria) this;
        }

        public Criteria andWorkerBankCardIsNotNull() {
            addCriterion("worker_bank_card is not null");
            return (Criteria) this;
        }

        public Criteria andWorkerBankCardEqualTo(String value) {
            addCriterion("worker_bank_card =", value, "workerBankCard");
            return (Criteria) this;
        }

        public Criteria andWorkerBankCardNotEqualTo(String value) {
            addCriterion("worker_bank_card <>", value, "workerBankCard");
            return (Criteria) this;
        }

        public Criteria andWorkerBankCardGreaterThan(String value) {
            addCriterion("worker_bank_card >", value, "workerBankCard");
            return (Criteria) this;
        }

        public Criteria andWorkerBankCardGreaterThanOrEqualTo(String value) {
            addCriterion("worker_bank_card >=", value, "workerBankCard");
            return (Criteria) this;
        }

        public Criteria andWorkerBankCardLessThan(String value) {
            addCriterion("worker_bank_card <", value, "workerBankCard");
            return (Criteria) this;
        }

        public Criteria andWorkerBankCardLessThanOrEqualTo(String value) {
            addCriterion("worker_bank_card <=", value, "workerBankCard");
            return (Criteria) this;
        }

        public Criteria andWorkerBankCardLike(String value) {
            addCriterion("worker_bank_card like", value, "workerBankCard");
            return (Criteria) this;
        }

        public Criteria andWorkerBankCardNotLike(String value) {
            addCriterion("worker_bank_card not like", value, "workerBankCard");
            return (Criteria) this;
        }

        public Criteria andWorkerBankCardIn(List<String> values) {
            addCriterion("worker_bank_card in", values, "workerBankCard");
            return (Criteria) this;
        }

        public Criteria andWorkerBankCardNotIn(List<String> values) {
            addCriterion("worker_bank_card not in", values, "workerBankCard");
            return (Criteria) this;
        }

        public Criteria andWorkerBankCardBetween(String value1, String value2) {
            addCriterion("worker_bank_card between", value1, value2, "workerBankCard");
            return (Criteria) this;
        }

        public Criteria andWorkerBankCardNotBetween(String value1, String value2) {
            addCriterion("worker_bank_card not between", value1, value2, "workerBankCard");
            return (Criteria) this;
        }

        public Criteria andPhotoIsNull() {
            addCriterion("photo is null");
            return (Criteria) this;
        }

        public Criteria andPhotoIsNotNull() {
            addCriterion("photo is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoEqualTo(String value) {
            addCriterion("photo =", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotEqualTo(String value) {
            addCriterion("photo <>", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoGreaterThan(String value) {
            addCriterion("photo >", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("photo >=", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLessThan(String value) {
            addCriterion("photo <", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLessThanOrEqualTo(String value) {
            addCriterion("photo <=", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLike(String value) {
            addCriterion("photo like", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotLike(String value) {
            addCriterion("photo not like", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoIn(List<String> values) {
            addCriterion("photo in", values, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotIn(List<String> values) {
            addCriterion("photo not in", values, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoBetween(String value1, String value2) {
            addCriterion("photo between", value1, value2, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotBetween(String value1, String value2) {
            addCriterion("photo not between", value1, value2, "photo");
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