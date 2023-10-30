package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class TestUtilTest {
    @Test
    @DisplayName("genScanner 테스트")
    void test1() {
        Scanner scanner = TestUtil.genScanner("""
        등록
        내용
        작가
        """.stripIndent());
        String cmd = scanner.nextLine();
        String content = scanner.nextLine();
        String author = scanner.nextLine();

        assertThat(cmd).isEqualTo("등록");
        assertThat(content).isEqualTo("내용");
        assertThat(author).isEqualTo("작가");

    }
}
