package com.example.springredditclone.service;

import com.example.springredditclone.exceptions.SpringRedditException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

public class CommentServiceTest {

    @Test
    @DisplayName("Test should pass when comment does not contain swear words")
    void shouldNotContainSwearWordsInsideComment() {
        CommentService commentService = new CommentService(null, null, null, null, null, null, null);
//        Assertions.assertFalse(commentService.containsSwearWords("This is a clean comment"));

        assertThat(commentService.containsSwearWords("This is a comment")).isFalse();
    }

    @Test
    @DisplayName("Test should throw exception when comment contains swear words")
    public void shouldThrowExceptionWhenCommentContainsSwearWords() {
        CommentService commentService = new CommentService(null, null, null, null, null, null, null);
//        SpringRedditException exception = assertThrows(SpringRedditException.class, () -> {
//            commentService.containsSwearWords("This is shitty comment!");
//        });
//        assertTrue(exception.getMessage().contains("Comment contains unacceptable language!"));

        assertThatThrownBy(() -> {
            commentService.containsSwearWords("This is shitty comment!");
        }).isInstanceOf(SpringRedditException.class)
                .hasMessage("Comment contains unacceptable language!");
    }
}