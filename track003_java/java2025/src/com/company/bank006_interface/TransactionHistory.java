package com.company.bank006_interface;

import java.util.List;

public class TransactionHistory implements Bank_Controller {

    @Override
    public int exec(List<UserInfo> users, int find) {
        UserInfo user = users.get(find);

        System.out.println("\n📜 거래 내역 (" + user.getName() + "님):");

        List<String> history = user.getHistory();

        if (history == null || history.isEmpty()) {
            System.out.println("  - 거래 내역이 없습니다.");
        } else {
            for (String record : history) {
                System.out.println("  • " + record);
            }
        }

        return 0;
    }
}
