package com.group.security.OrderDTO;

import java.math.BigDecimal;

public class OrderInfoDTO {
    private String order_id;
    private BigDecimal amount;
    private String currency;
    private String NIC;
    private String first_name;
    private String last_name;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String country;
    private String merchantId;
    private String merchantSecret;
    private String amountFormatted;
    private String hash;

    public OrderInfoDTO(String order_id,BigDecimal amount,String currency,String NIC,String first_name,String last_name,String email,String phone,String address,String city,String country,String merchantId,String merchantSecret,String amountFormatted,String hash){
        this.order_id = order_id;
        this.amount = amount;
        this.currency = currency;
        this.NIC = NIC;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.country = country;
        this.merchantId = merchantId;
        this.merchantSecret = merchantSecret;
        this.amountFormatted = amountFormatted;
        this.hash = hash;

    }

    public OrderInfoDTO() {

    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantSecret() {
        return merchantSecret;
    }

    public void setMerchantSecret(String merchantSecret) {
        this.merchantSecret = merchantSecret;
    }

    public String getAmountFormatted() {
        return amountFormatted;
    }

    public void setAmountFormatted(String amountFormatted) {
        this.amountFormatted = amountFormatted;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

//    public void setTransaction_id(String transactionId) {
//
//    }
//
//    public void setPayment_status(String paymentStatus) {
//    }
}
