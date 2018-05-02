package com.cr.domain;

import java.util.ArrayList;
import java.util.List;

public class BusinessExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BusinessExample() {
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

        public Criteria andBusLoginnameIsNull() {
            addCriterion("bus_loginname is null");
            return (Criteria) this;
        }

        public Criteria andBusLoginnameIsNotNull() {
            addCriterion("bus_loginname is not null");
            return (Criteria) this;
        }

        public Criteria andBusLoginnameEqualTo(String value) {
            addCriterion("bus_loginname =", value, "busLoginname");
            return (Criteria) this;
        }

        public Criteria andBusLoginnameNotEqualTo(String value) {
            addCriterion("bus_loginname <>", value, "busLoginname");
            return (Criteria) this;
        }

        public Criteria andBusLoginnameGreaterThan(String value) {
            addCriterion("bus_loginname >", value, "busLoginname");
            return (Criteria) this;
        }

        public Criteria andBusLoginnameGreaterThanOrEqualTo(String value) {
            addCriterion("bus_loginname >=", value, "busLoginname");
            return (Criteria) this;
        }

        public Criteria andBusLoginnameLessThan(String value) {
            addCriterion("bus_loginname <", value, "busLoginname");
            return (Criteria) this;
        }

        public Criteria andBusLoginnameLessThanOrEqualTo(String value) {
            addCriterion("bus_loginname <=", value, "busLoginname");
            return (Criteria) this;
        }

        public Criteria andBusLoginnameLike(String value) {
            addCriterion("bus_loginname like", value, "busLoginname");
            return (Criteria) this;
        }

        public Criteria andBusLoginnameNotLike(String value) {
            addCriterion("bus_loginname not like", value, "busLoginname");
            return (Criteria) this;
        }

        public Criteria andBusLoginnameIn(List<String> values) {
            addCriterion("bus_loginname in", values, "busLoginname");
            return (Criteria) this;
        }

        public Criteria andBusLoginnameNotIn(List<String> values) {
            addCriterion("bus_loginname not in", values, "busLoginname");
            return (Criteria) this;
        }

        public Criteria andBusLoginnameBetween(String value1, String value2) {
            addCriterion("bus_loginname between", value1, value2, "busLoginname");
            return (Criteria) this;
        }

        public Criteria andBusLoginnameNotBetween(String value1, String value2) {
            addCriterion("bus_loginname not between", value1, value2, "busLoginname");
            return (Criteria) this;
        }

        public Criteria andBusPasswordIsNull() {
            addCriterion("bus_password is null");
            return (Criteria) this;
        }

        public Criteria andBusPasswordIsNotNull() {
            addCriterion("bus_password is not null");
            return (Criteria) this;
        }

        public Criteria andBusPasswordEqualTo(String value) {
            addCriterion("bus_password =", value, "busPassword");
            return (Criteria) this;
        }

        public Criteria andBusPasswordNotEqualTo(String value) {
            addCriterion("bus_password <>", value, "busPassword");
            return (Criteria) this;
        }

        public Criteria andBusPasswordGreaterThan(String value) {
            addCriterion("bus_password >", value, "busPassword");
            return (Criteria) this;
        }

        public Criteria andBusPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("bus_password >=", value, "busPassword");
            return (Criteria) this;
        }

        public Criteria andBusPasswordLessThan(String value) {
            addCriterion("bus_password <", value, "busPassword");
            return (Criteria) this;
        }

        public Criteria andBusPasswordLessThanOrEqualTo(String value) {
            addCriterion("bus_password <=", value, "busPassword");
            return (Criteria) this;
        }

        public Criteria andBusPasswordLike(String value) {
            addCriterion("bus_password like", value, "busPassword");
            return (Criteria) this;
        }

        public Criteria andBusPasswordNotLike(String value) {
            addCriterion("bus_password not like", value, "busPassword");
            return (Criteria) this;
        }

        public Criteria andBusPasswordIn(List<String> values) {
            addCriterion("bus_password in", values, "busPassword");
            return (Criteria) this;
        }

        public Criteria andBusPasswordNotIn(List<String> values) {
            addCriterion("bus_password not in", values, "busPassword");
            return (Criteria) this;
        }

        public Criteria andBusPasswordBetween(String value1, String value2) {
            addCriterion("bus_password between", value1, value2, "busPassword");
            return (Criteria) this;
        }

        public Criteria andBusPasswordNotBetween(String value1, String value2) {
            addCriterion("bus_password not between", value1, value2, "busPassword");
            return (Criteria) this;
        }

        public Criteria andBusNameIsNull() {
            addCriterion("bus_name is null");
            return (Criteria) this;
        }

        public Criteria andBusNameIsNotNull() {
            addCriterion("bus_name is not null");
            return (Criteria) this;
        }

        public Criteria andBusNameEqualTo(String value) {
            addCriterion("bus_name =", value, "busName");
            return (Criteria) this;
        }

        public Criteria andBusNameNotEqualTo(String value) {
            addCriterion("bus_name <>", value, "busName");
            return (Criteria) this;
        }

        public Criteria andBusNameGreaterThan(String value) {
            addCriterion("bus_name >", value, "busName");
            return (Criteria) this;
        }

        public Criteria andBusNameGreaterThanOrEqualTo(String value) {
            addCriterion("bus_name >=", value, "busName");
            return (Criteria) this;
        }

        public Criteria andBusNameLessThan(String value) {
            addCriterion("bus_name <", value, "busName");
            return (Criteria) this;
        }

        public Criteria andBusNameLessThanOrEqualTo(String value) {
            addCriterion("bus_name <=", value, "busName");
            return (Criteria) this;
        }

        public Criteria andBusNameLike(String value) {
            addCriterion("bus_name like", value, "busName");
            return (Criteria) this;
        }

        public Criteria andBusNameNotLike(String value) {
            addCriterion("bus_name not like", value, "busName");
            return (Criteria) this;
        }

        public Criteria andBusNameIn(List<String> values) {
            addCriterion("bus_name in", values, "busName");
            return (Criteria) this;
        }

        public Criteria andBusNameNotIn(List<String> values) {
            addCriterion("bus_name not in", values, "busName");
            return (Criteria) this;
        }

        public Criteria andBusNameBetween(String value1, String value2) {
            addCriterion("bus_name between", value1, value2, "busName");
            return (Criteria) this;
        }

        public Criteria andBusNameNotBetween(String value1, String value2) {
            addCriterion("bus_name not between", value1, value2, "busName");
            return (Criteria) this;
        }

        public Criteria andBusImgIsNull() {
            addCriterion("bus_img is null");
            return (Criteria) this;
        }

        public Criteria andBusImgIsNotNull() {
            addCriterion("bus_img is not null");
            return (Criteria) this;
        }

        public Criteria andBusImgEqualTo(String value) {
            addCriterion("bus_img =", value, "busImg");
            return (Criteria) this;
        }

        public Criteria andBusImgNotEqualTo(String value) {
            addCriterion("bus_img <>", value, "busImg");
            return (Criteria) this;
        }

        public Criteria andBusImgGreaterThan(String value) {
            addCriterion("bus_img >", value, "busImg");
            return (Criteria) this;
        }

        public Criteria andBusImgGreaterThanOrEqualTo(String value) {
            addCriterion("bus_img >=", value, "busImg");
            return (Criteria) this;
        }

        public Criteria andBusImgLessThan(String value) {
            addCriterion("bus_img <", value, "busImg");
            return (Criteria) this;
        }

        public Criteria andBusImgLessThanOrEqualTo(String value) {
            addCriterion("bus_img <=", value, "busImg");
            return (Criteria) this;
        }

        public Criteria andBusImgLike(String value) {
            addCriterion("bus_img like", value, "busImg");
            return (Criteria) this;
        }

        public Criteria andBusImgNotLike(String value) {
            addCriterion("bus_img not like", value, "busImg");
            return (Criteria) this;
        }

        public Criteria andBusImgIn(List<String> values) {
            addCriterion("bus_img in", values, "busImg");
            return (Criteria) this;
        }

        public Criteria andBusImgNotIn(List<String> values) {
            addCriterion("bus_img not in", values, "busImg");
            return (Criteria) this;
        }

        public Criteria andBusImgBetween(String value1, String value2) {
            addCriterion("bus_img between", value1, value2, "busImg");
            return (Criteria) this;
        }

        public Criteria andBusImgNotBetween(String value1, String value2) {
            addCriterion("bus_img not between", value1, value2, "busImg");
            return (Criteria) this;
        }

        public Criteria andBusLicenseIsNull() {
            addCriterion("bus_license is null");
            return (Criteria) this;
        }

        public Criteria andBusLicenseIsNotNull() {
            addCriterion("bus_license is not null");
            return (Criteria) this;
        }

        public Criteria andBusLicenseEqualTo(String value) {
            addCriterion("bus_license =", value, "busLicense");
            return (Criteria) this;
        }

        public Criteria andBusLicenseNotEqualTo(String value) {
            addCriterion("bus_license <>", value, "busLicense");
            return (Criteria) this;
        }

        public Criteria andBusLicenseGreaterThan(String value) {
            addCriterion("bus_license >", value, "busLicense");
            return (Criteria) this;
        }

        public Criteria andBusLicenseGreaterThanOrEqualTo(String value) {
            addCriterion("bus_license >=", value, "busLicense");
            return (Criteria) this;
        }

        public Criteria andBusLicenseLessThan(String value) {
            addCriterion("bus_license <", value, "busLicense");
            return (Criteria) this;
        }

        public Criteria andBusLicenseLessThanOrEqualTo(String value) {
            addCriterion("bus_license <=", value, "busLicense");
            return (Criteria) this;
        }

        public Criteria andBusLicenseLike(String value) {
            addCriterion("bus_license like", value, "busLicense");
            return (Criteria) this;
        }

        public Criteria andBusLicenseNotLike(String value) {
            addCriterion("bus_license not like", value, "busLicense");
            return (Criteria) this;
        }

        public Criteria andBusLicenseIn(List<String> values) {
            addCriterion("bus_license in", values, "busLicense");
            return (Criteria) this;
        }

        public Criteria andBusLicenseNotIn(List<String> values) {
            addCriterion("bus_license not in", values, "busLicense");
            return (Criteria) this;
        }

        public Criteria andBusLicenseBetween(String value1, String value2) {
            addCriterion("bus_license between", value1, value2, "busLicense");
            return (Criteria) this;
        }

        public Criteria andBusLicenseNotBetween(String value1, String value2) {
            addCriterion("bus_license not between", value1, value2, "busLicense");
            return (Criteria) this;
        }

        public Criteria andBusAddressIsNull() {
            addCriterion("bus_address is null");
            return (Criteria) this;
        }

        public Criteria andBusAddressIsNotNull() {
            addCriterion("bus_address is not null");
            return (Criteria) this;
        }

        public Criteria andBusAddressEqualTo(String value) {
            addCriterion("bus_address =", value, "busAddress");
            return (Criteria) this;
        }

        public Criteria andBusAddressNotEqualTo(String value) {
            addCriterion("bus_address <>", value, "busAddress");
            return (Criteria) this;
        }

        public Criteria andBusAddressGreaterThan(String value) {
            addCriterion("bus_address >", value, "busAddress");
            return (Criteria) this;
        }

        public Criteria andBusAddressGreaterThanOrEqualTo(String value) {
            addCriterion("bus_address >=", value, "busAddress");
            return (Criteria) this;
        }

        public Criteria andBusAddressLessThan(String value) {
            addCriterion("bus_address <", value, "busAddress");
            return (Criteria) this;
        }

        public Criteria andBusAddressLessThanOrEqualTo(String value) {
            addCriterion("bus_address <=", value, "busAddress");
            return (Criteria) this;
        }

        public Criteria andBusAddressLike(String value) {
            addCriterion("bus_address like", value, "busAddress");
            return (Criteria) this;
        }

        public Criteria andBusAddressNotLike(String value) {
            addCriterion("bus_address not like", value, "busAddress");
            return (Criteria) this;
        }

        public Criteria andBusAddressIn(List<String> values) {
            addCriterion("bus_address in", values, "busAddress");
            return (Criteria) this;
        }

        public Criteria andBusAddressNotIn(List<String> values) {
            addCriterion("bus_address not in", values, "busAddress");
            return (Criteria) this;
        }

        public Criteria andBusAddressBetween(String value1, String value2) {
            addCriterion("bus_address between", value1, value2, "busAddress");
            return (Criteria) this;
        }

        public Criteria andBusAddressNotBetween(String value1, String value2) {
            addCriterion("bus_address not between", value1, value2, "busAddress");
            return (Criteria) this;
        }

        public Criteria andIsCheckIsNull() {
            addCriterion("is_check is null");
            return (Criteria) this;
        }

        public Criteria andIsCheckIsNotNull() {
            addCriterion("is_check is not null");
            return (Criteria) this;
        }

        public Criteria andIsCheckEqualTo(String value) {
            addCriterion("is_check =", value, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckNotEqualTo(String value) {
            addCriterion("is_check <>", value, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckGreaterThan(String value) {
            addCriterion("is_check >", value, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckGreaterThanOrEqualTo(String value) {
            addCriterion("is_check >=", value, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckLessThan(String value) {
            addCriterion("is_check <", value, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckLessThanOrEqualTo(String value) {
            addCriterion("is_check <=", value, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckLike(String value) {
            addCriterion("is_check like", value, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckNotLike(String value) {
            addCriterion("is_check not like", value, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckIn(List<String> values) {
            addCriterion("is_check in", values, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckNotIn(List<String> values) {
            addCriterion("is_check not in", values, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckBetween(String value1, String value2) {
            addCriterion("is_check between", value1, value2, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckNotBetween(String value1, String value2) {
            addCriterion("is_check not between", value1, value2, "isCheck");
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