package org.example.global.app;

import org.example.domain.wisesaing.wisesaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private final Scanner scanner;

    public App(final Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        System.out.println("== 명언 앱 ==");

        List<WiseSaying> wiseSayings = new ArrayList<>();
        long lastWiseSayingId = 0;

        while (true) {
            String cmd = scanner.nextLine().trim();

            switch (cmd) {
                case "등록" -> {
                    System.out.print("명언 : ");
                    String content = scanner.nextLine().trim();
                    System.out.print("작가 : ");
                    String author = scanner.nextLine().trim();

                    long id = ++lastWiseSayingId;

                    WiseSaying wiseSaying = new WiseSaying(id, author, content);
                    wiseSayings.add(wiseSaying);

                    System.out.println("%d번 명언이 등록되었습니다.".formatted(id));
                }
                case "목록" -> {
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("----------------------");

                    wiseSayings
                            .reversed()
                            .forEach(wiseSaying -> System.out.println(
                                            "%d / %s / %s".formatted(
                                                    wiseSaying.getId(),
                                                    wiseSaying.getAuthor(),
                                                    wiseSaying.getContent()
                                            )
                                    )
                            );
                }
                case "종료" -> {
                    return;
                }
            }
        }

    }


//    private final Scanner scanner;
//
//    public App(Scanner scanner) {
//        this.scanner = scanner;
//    }
//
//    public void run() {
//        System.out.println("== 명언 앱 ==");
//
//        while (true) {
//            System.out.print("명령) ");
//            String cmd = scanner.nextLine();
//
//            if (cmd.equals("종료")) {
//                break;
//            }
//            else if (cmd.equals("등록")) {
//                System.out.print("명언 : ");
//                String word = scanner.nextLine();
//                System.out.print("작가 : ");
//                String author = scanner.nextLine();
//
//                System.out.println("1번 명언이 등록되었습니다.");
//
//                break;
//            }
//        }
//    }
}
