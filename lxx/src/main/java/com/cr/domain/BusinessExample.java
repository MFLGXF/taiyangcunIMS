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

        public Criteria andYIsNull() {
            addCriterion("y is null");
            return (Criteria) this;
        }

        public Criteria andYIsNotNull() {
            addCriterion("y is not null");
            return (Criteria) this;
        }

        public Criteria andYEqualTo(String value) {
            addCriterion("y =", value, "y");
            return (Criteria) this;
        }

        public Criteria andYNotEqualTo(String value) {
            addCriterion("y <>", value, "y");
            return (Criteria) this;
        }

        public Criteria andYGreaterThan(String value) {
            addCriterion("y >", value, "y");
            return (Criteria) this;
        }

        public Criteria andYGreaterThanOrEqualTo(String value) {
            addCriterion("y >=", value, "y");
            return (Criteria) this;
        }

        public Criteria andYLessThan(String value) {
            addCriterion("y <", value, "y");
            return (Criteria) this;
        }

        public Criteria andYLessThanOrEqualTo(String value) {
            addCriterion("y <=", value, "y");
            return (Criteria) this;
        }

        public Criteria andYLike(String value) {
            addCriterion("y like", value, "y");
            return (Criteria) this;
        }

        public Criteria andYNotLike(String value) {
            addCriterion("y not like", value, "y");
            return (Criteria) this;
        }

        public Criteria andYIn(List<String> values) {
            addCriterion("y in", values, "y");
            return (Criteria) this;
        }

        public Criteria andYNotIn(List<String> values) {
            addCriterion("y not in", values, "y");
            return (Criteria) this;
        }

        public Criteria andYBetween(String value1, String value2) {
            addCriterion("y between", value1, value2, "y");
            return (Criteria) this;
        }

        public Criteria andYNotBetween(String value1, String value2) {
            addCriterion("y not between", value1, value2, "y");
            return (Criteria) this;
        }

        public Criteria andXIsNull() {
            addCriterion("x is null");
            return (Criteria) this;
        }

        public Criteria andXIsNotNull() {
            addCriterion("x is not null");
            return (Criteria) this;
        }

        public Criteria andXEqualTo(String value) {
            addCriterion("x =", value, "x");
            return (Criteria) this;
        }

        public Criteria andXNotEqualTo(String value) {
            addCriterion("x <>", value, "x");
            return (Criteria) this;
        }

        public Criteria andXGreaterThan(String value) {
            addCriterion("x >", value, "x");
            return (Criteria) this;
        }

        public Criteria andXGreaterThanOrEqualTo(String value) {
            addCriterion("x >=", value, "x");
            return (Criteria) this;
        }

        public Criteria andXLessThan(String value) {
            addCriterion("x <", value, "x");
            return (Criteria) this;
        }

        public Criteria andXLessThanOrEqualTo(String value) {
            addCriterion("x <=", value, "x");
            return (Criteria) this;
        }

        public Criteria andXLike(String value) {
            addCriterion("x like", value, "x");
            return (Criteria) this;
        }

        public Criteria andXNotLike(String value) {
            addCriterion("x not like", value, "x");
            return (Criteria) this;
        }

        public Criteria andXIn(List<String> values) {
            addCriterion("x in", values, "x");
            return (Criteria) this;
        }

        public Criteria andXNotIn(List<String> values) {
            addCriterion("x not in", values, "x");
            return (Criteria) this;
        }

        public Criteria andXBetween(String value1, String value2) {
            addCriterion("x between", value1, value2, "x");
            return (Criteria) this;
        }

        public Criteria andXNotBetween(String value1, String value2) {
            addCriterion("x not between", value1, value2, "x");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyLeaderIsNull() {
            addCriterion("company_leader is null");
            return (Criteria) this;
        }

        public Criteria andCompanyLeaderIsNotNull() {
            addCriterion("company_leader is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyLeaderEqualTo(String value) {
            addCriterion("company_leader =", value, "companyLeader");
            return (Criteria) this;
        }

        public Criteria andCompanyLeaderNotEqualTo(String value) {
            addCriterion("company_leader <>", value, "companyLeader");
            return (Criteria) this;
        }

        public Criteria andCompanyLeaderGreaterThan(String value) {
            addCriterion("company_leader >", value, "companyLeader");
            return (Criteria) this;
        }

        public Criteria andCompanyLeaderGreaterThanOrEqualTo(String value) {
            addCriterion("company_leader >=", value, "companyLeader");
            return (Criteria) this;
        }

        public Criteria andCompanyLeaderLessThan(String value) {
            addCriterion("company_leader <", value, "companyLeader");
            return (Criteria) this;
        }

        public Criteria andCompanyLeaderLessThanOrEqualTo(String value) {
            addCriterion("company_leader <=", value, "companyLeader");
            return (Criteria) this;
        }

        public Criteria andCompanyLeaderLike(String value) {
            addCriterion("company_leader like", value, "companyLeader");
            return (Criteria) this;
        }

        public Criteria andCompanyLeaderNotLike(String value) {
            addCriterion("company_leader not like", value, "companyLeader");
            return (Criteria) this;
        }

        public Criteria andCompanyLeaderIn(List<String> values) {
            addCriterion("company_leader in", values, "companyLeader");
            return (Criteria) this;
        }

        public Criteria andCompanyLeaderNotIn(List<String> values) {
            addCriterion("company_leader not in", values, "companyLeader");
            return (Criteria) this;
        }

        public Criteria andCompanyLeaderBetween(String value1, String value2) {
            addCriterion("company_leader between", value1, value2, "companyLeader");
            return (Criteria) this;
        }

        public Criteria andCompanyLeaderNotBetween(String value1, String value2) {
            addCriterion("company_leader not between", value1, value2, "companyLeader");
            return (Criteria) this;
        }

        public Criteria andScaleIsNull() {
            addCriterion("scale is null");
            return (Criteria) this;
        }

        public Criteria andScaleIsNotNull() {
            addCriterion("scale is not null");
            return (Criteria) this;
        }

        public Criteria andScaleEqualTo(Integer value) {
            addCriterion("scale =", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleNotEqualTo(Integer value) {
            addCriterion("scale <>", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleGreaterThan(Integer value) {
            addCriterion("scale >", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleGreaterThanOrEqualTo(Integer value) {
            addCriterion("scale >=", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleLessThan(Integer value) {
            addCriterion("scale <", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleLessThanOrEqualTo(Integer value) {
            addCriterion("scale <=", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleIn(List<Integer> values) {
            addCriterion("scale in", values, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleNotIn(List<Integer> values) {
            addCriterion("scale not in", values, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleBetween(Integer value1, Integer value2) {
            addCriterion("scale between", value1, value2, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleNotBetween(Integer value1, Integer value2) {
            addCriterion("scale not between", value1, value2, "scale");
            return (Criteria) this;
        }

        public Criteria andRevenueIsNull() {
            addCriterion("revenue is null");
            return (Criteria) this;
        }

        public Criteria andRevenueIsNotNull() {
            addCriterion("revenue is not null");
            return (Criteria) this;
        }

        public Criteria andRevenueEqualTo(String value) {
            addCriterion("revenue =", value, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueNotEqualTo(String value) {
            addCriterion("revenue <>", value, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueGreaterThan(String value) {
            addCriterion("revenue >", value, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueGreaterThanOrEqualTo(String value) {
            addCriterion("revenue >=", value, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueLessThan(String value) {
            addCriterion("revenue <", value, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueLessThanOrEqualTo(String value) {
            addCriterion("revenue <=", value, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueLike(String value) {
            addCriterion("revenue like", value, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueNotLike(String value) {
            addCriterion("revenue not like", value, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueIn(List<String> values) {
            addCriterion("revenue in", values, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueNotIn(List<String> values) {
            addCriterion("revenue not in", values, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueBetween(String value1, String value2) {
            addCriterion("revenue between", value1, value2, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueNotBetween(String value1, String value2) {
            addCriterion("revenue not between", value1, value2, "revenue");
            return (Criteria) this;
        }

        public Criteria andTaxesIsNull() {
            addCriterion("taxes is null");
            return (Criteria) this;
        }

        public Criteria andTaxesIsNotNull() {
            addCriterion("taxes is not null");
            return (Criteria) this;
        }

        public Criteria andTaxesEqualTo(String value) {
            addCriterion("taxes =", value, "taxes");
            return (Criteria) this;
        }

        public Criteria andTaxesNotEqualTo(String value) {
            addCriterion("taxes <>", value, "taxes");
            return (Criteria) this;
        }

        public Criteria andTaxesGreaterThan(String value) {
            addCriterion("taxes >", value, "taxes");
            return (Criteria) this;
        }

        public Criteria andTaxesGreaterThanOrEqualTo(String value) {
            addCriterion("taxes >=", value, "taxes");
            return (Criteria) this;
        }

        public Criteria andTaxesLessThan(String value) {
            addCriterion("taxes <", value, "taxes");
            return (Criteria) this;
        }

        public Criteria andTaxesLessThanOrEqualTo(String value) {
            addCriterion("taxes <=", value, "taxes");
            return (Criteria) this;
        }

        public Criteria andTaxesLike(String value) {
            addCriterion("taxes like", value, "taxes");
            return (Criteria) this;
        }

        public Criteria andTaxesNotLike(String value) {
            addCriterion("taxes not like", value, "taxes");
            return (Criteria) this;
        }

        public Criteria andTaxesIn(List<String> values) {
            addCriterion("taxes in", values, "taxes");
            return (Criteria) this;
        }

        public Criteria andTaxesNotIn(List<String> values) {
            addCriterion("taxes not in", values, "taxes");
            return (Criteria) this;
        }

        public Criteria andTaxesBetween(String value1, String value2) {
            addCriterion("taxes between", value1, value2, "taxes");
            return (Criteria) this;
        }

        public Criteria andTaxesNotBetween(String value1, String value2) {
            addCriterion("taxes not between", value1, value2, "taxes");
            return (Criteria) this;
        }

        public Criteria andLogoIsNull() {
            addCriterion("logo is null");
            return (Criteria) this;
        }

        public Criteria andLogoIsNotNull() {
            addCriterion("logo is not null");
            return (Criteria) this;
        }

        public Criteria andLogoEqualTo(String value) {
            addCriterion("logo =", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotEqualTo(String value) {
            addCriterion("logo <>", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoGreaterThan(String value) {
            addCriterion("logo >", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoGreaterThanOrEqualTo(String value) {
            addCriterion("logo >=", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoLessThan(String value) {
            addCriterion("logo <", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoLessThanOrEqualTo(String value) {
            addCriterion("logo <=", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoLike(String value) {
            addCriterion("logo like", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotLike(String value) {
            addCriterion("logo not like", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoIn(List<String> values) {
            addCriterion("logo in", values, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotIn(List<String> values) {
            addCriterion("logo not in", values, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoBetween(String value1, String value2) {
            addCriterion("logo between", value1, value2, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotBetween(String value1, String value2) {
            addCriterion("logo not between", value1, value2, "logo");
            return (Criteria) this;
        }

        public Criteria andIndustryIsNull() {
            addCriterion("industry is null");
            return (Criteria) this;
        }

        public Criteria andIndustryIsNotNull() {
            addCriterion("industry is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryEqualTo(String value) {
            addCriterion("industry =", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotEqualTo(String value) {
            addCriterion("industry <>", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryGreaterThan(String value) {
            addCriterion("industry >", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryGreaterThanOrEqualTo(String value) {
            addCriterion("industry >=", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLessThan(String value) {
            addCriterion("industry <", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLessThanOrEqualTo(String value) {
            addCriterion("industry <=", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLike(String value) {
            addCriterion("industry like", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotLike(String value) {
            addCriterion("industry not like", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryIn(List<String> values) {
            addCriterion("industry in", values, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotIn(List<String> values) {
            addCriterion("industry not in", values, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryBetween(String value1, String value2) {
            addCriterion("industry between", value1, value2, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotBetween(String value1, String value2) {
            addCriterion("industry not between", value1, value2, "industry");
            return (Criteria) this;
        }

        public Criteria andIsLocalIsNull() {
            addCriterion("is_local is null");
            return (Criteria) this;
        }

        public Criteria andIsLocalIsNotNull() {
            addCriterion("is_local is not null");
            return (Criteria) this;
        }

        public Criteria andIsLocalEqualTo(Integer value) {
            addCriterion("is_local =", value, "isLocal");
            return (Criteria) this;
        }

        public Criteria andIsLocalNotEqualTo(Integer value) {
            addCriterion("is_local <>", value, "isLocal");
            return (Criteria) this;
        }

        public Criteria andIsLocalGreaterThan(Integer value) {
            addCriterion("is_local >", value, "isLocal");
            return (Criteria) this;
        }

        public Criteria andIsLocalGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_local >=", value, "isLocal");
            return (Criteria) this;
        }

        public Criteria andIsLocalLessThan(Integer value) {
            addCriterion("is_local <", value, "isLocal");
            return (Criteria) this;
        }

        public Criteria andIsLocalLessThanOrEqualTo(Integer value) {
            addCriterion("is_local <=", value, "isLocal");
            return (Criteria) this;
        }

        public Criteria andIsLocalIn(List<Integer> values) {
            addCriterion("is_local in", values, "isLocal");
            return (Criteria) this;
        }

        public Criteria andIsLocalNotIn(List<Integer> values) {
            addCriterion("is_local not in", values, "isLocal");
            return (Criteria) this;
        }

        public Criteria andIsLocalBetween(Integer value1, Integer value2) {
            addCriterion("is_local between", value1, value2, "isLocal");
            return (Criteria) this;
        }

        public Criteria andIsLocalNotBetween(Integer value1, Integer value2) {
            addCriterion("is_local not between", value1, value2, "isLocal");
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