package com.company.bank006_interface;

import java.util.ArrayList;
import java.util.List;

public class UserInfo {
    private String id;
    private String pass;
    private double balance;
    private String accNum; // 계좌번호
    private String name;   // 사용자 이름
    private List<String> history; // 거래 내역

    public UserInfo() {
        this.history = new ArrayList<>();
    }

    public UserInfo(String id, String pass, double balance, String accNum, String name) {
        this.id = id;
        this.pass = pass;
        this.balance = balance;
        this.accNum = accNum;
        this.name = name;
        this.history = new ArrayList<>();
    }
    
    public UserInfo(String id, String pass, double balance) {
        this.id = id;
        this.pass = pass;
        this.balance = balance;
    }

    @Override
	public String toString() {
		return "UserInfo [id=" + id + ", pass=" + pass + ", balance=" + balance + "]";
	}

    // Getter & Setter
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getPass() { return pass; }
    public void setPass(String pass) { this.pass = pass; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }

    public String getAccNum() { return accNum; }
    public void setAccNum(String accNum) { this.accNum = accNum; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<String> getHistory() { return history; }
    public void addHistory(String record) { this.history.add(record); }
}
