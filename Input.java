package Memo_test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Input {
    Map<Integer, Memo> memoList = new LinkedHashMap<>();
    Memo memo = new Memo("", "", "", "");

    public void inputMemo(int textNum, String name, String password, String text, String now) {
        Memo memo = new Memo(name, password, text, now);
        memoList.put(textNum, memo);
    }

    public void printMemo() {
        Set<Integer> keySet = memoList.keySet();
        for (Integer key : keySet) {
            System.out.println(key+1 + ". \n" + memoList.get(key));
        }
    }

    public void updateMemo(int textNum, String name, String password, String text,String now) {
        Memo memo = new Memo(name, password, text, now);
        memoList.put(textNum, memo);
    }

    public void updateText(int textNum) {
        Scanner sc = new Scanner(System.in);

        System.out.println("해당 글을 수정하시겠습니까?");
        System.out.println("1. 확인    | 2. 취소");
        int confirm = sc.nextInt();
        sc.nextLine();

        if (confirm == 1) {
            System.out.println("비밀번호 입력");
            String passwd = sc.nextLine();

            Memo update = memoList.get(textNum-1);
            String updates = update.getPassword();

            if(passwd.equals(updates)) {
                System.out.print("\n이름 : ");
                String name = sc.nextLine();

                System.out.print("비밀번호 : ");
                String password = sc.nextLine();

                System.out.print("내용 : ");
                String text = sc.nextLine();

                LocalDateTime now = LocalDateTime.now();
                String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"));

                updateMemo(textNum-1, name, password, text, formatedNow);
            } else {
                System.out.println("비밀번호가 틀렸습니다. 다시 입력하세요.");
            }
        } else if (confirm == 2) {
            System.out.println("메인으로 돌아갑니다.");
            return;
        }
    }

    public void deleteText(int num) {
        Scanner sc = new Scanner(System.in);
        if (num > 0 && num <= memoList.size()) {
            System.out.println("해당 글을 삭제하시겠습니까?");
            System.out.println("1. 확인    | 2. 취소");
        } else {
            System.out.println("해당번호의 글이 존재하지 않습니다.");
            return;
        }
        int confirm = sc.nextInt();
        sc.nextLine();

        if (confirm == 1) {
            System.out.println("비밀번호를 입력하세요.");
            String passNum = sc.nextLine();

            Memo memo2 = memoList.get(num-1);
            String memoPassword = memo2.getPassword();
            if (passNum.equals(memoPassword)) {
                memoList.remove(num - 1);
                while (memoList.containsKey(num)) {
                    Memo memo = memoList.get(num);
                    memoList.remove(num);
                    memoList.put(num - 1, memo);
                }} else {
                System.out.println("비밀번호가 일치하지 않습니다. 글을 삭제할 수 없습니다.");
                return;
            }

        } else if (confirm == 2) {
            System.out.println("메인으로 돌아갑니다.");
            return;
        }
        System.out.println("삭제가 완료되었습니다.");
    }
}
