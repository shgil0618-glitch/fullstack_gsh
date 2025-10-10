package com.company.bank006_interface;

import java.util.List;
import java.util.Scanner;

public class Transfer implements Bank_Controller {

    @Override
    public int exec(List<UserInfo> users, int find) {
        Scanner scanner = new Scanner(System.in);
        UserInfo sender = users.get(find);

        System.out.print("🔍 이체할 대상 계좌번호 입력: ");
        String targetAccNum = scanner.next();

        // 대상 계좌 찾기
        int targetIndex = -1;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getAccNum().equals(targetAccNum)) {
                targetIndex = i;
                break;
            }
        }

        if (targetIndex == -1) {
            System.out.println("❌ 존재하지 않는 계좌번호입니다.");
            return 0;
        }

        UserInfo receiver = users.get(targetIndex);

        System.out.print("💰 이체할 금액 입력: ");
        double amount = scanner.nextDouble();

        if (sender.getBalance() < amount) {
            System.out.println("❌ 잔액이 부족합니다.");
            return 0;
        }

        // 이체 처리
        sender.setBalance(sender.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);

        // 거래 내역 기록
        String sendLog = String.format("보냄 → %s 금액: ₩%.0f", receiver.getAccNum(), amount);
        String receiveLog = String.format("받음 ← %s 금액: ₩%.0f", sender.getAccNum(), amount);

        sender.addHistory(sendLog);
        receiver.addHistory(receiveLog);

        System.out.println("✅ 이체 완료!");
        System.out.println("📉 보낸 사람 잔액: ₩" + sender.getBalance());
        System.out.println("📈 받은 사람 잔액: ₩" + receiver.getBalance());

        return 0;
    }
}
