package com.fwx.domain;
/**
 * 订单类
 *  [一句话功能简述]
 *  [功能详细描述]
 * @作者 mflgx
 * @version [版本号, 2018年4月28日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class Order
{
    private String id;
    
    /*
     * 用户姓名
     */
    private String username;
    
    /*
     * 用户电话
     */
    private String phone;
    
    /*
     * 预约时间
     */
    private String orderTime;
    
    /*
     * 价格
     */
    private int price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", username=" + username + ", phone=" + phone + ", orderTime=" + orderTime
                + ", price=" + price + "]";
    }
    
}
