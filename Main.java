package Memo_test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int textNum = 0;
        boolean start = true;
        Input input = new Input();

        while (start) {

            Scanner sc = new Scanner(System.in);

            LocalDateTime now = LocalDateTime.now();
            String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"));

            System.out.println("[ 메모장 ]");
            System.out.println("1. 글 작성");
            System.out.println("2. 목록 보기");
            System.out.println("3. 글 수정");
            System.out.println("4. 글 삭제");
            System.out.println("5. 종료\n");

            System.out.print("입력 : ");

            int num = sc.nextInt();
            sc.nextLine();

            switch (num) {
                case 1 :
                    System.out.print("\n이름 : ");
                    String name = sc.nextLine();

                    System.out.print("비밀번호 : ");
                    String password = sc.nextLine();

                    System.out.print("내용 : ");
                    String text = sc.nextLine();

                    input.inputMemo(textNum, name, password, text,formatedNow);
                    textNum++;

                    System.out.println();
                    break;
                case 2 :
                    input.printMemo();
                    System.out.println();

                    break;
                case 3 :
                    System.out.println("수정할 번호를 입력하세요");
                    int updateNum = sc.nextInt();
                    input.updateText(updateNum);
                    break;
                case 4 :
                    System.out.println("삭제할 번호를 입력하세요");
                    int deleteNum = sc.nextInt();
                    input.deleteText(deleteNum);
                    textNum--;
                    break;
                case 5:
                    System.out.println("종료합니다.\n");
                    start = false;
                    break;
            }
        }
    }
}

