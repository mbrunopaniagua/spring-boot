package com.example.palindrome;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.stream.IntStream;

@Controller
public class PalindromeController {

	@GetMapping("/palindrome")
	public String palindrome(@RequestParam(name = "phrase") String phrase, Model model) {
		model.addAttribute("phrase", phrase);
		model.addAttribute("isPalindrome", isPalindrome(phrase));
		return "result";
	}

	@GetMapping("/palindrome/reverse")
	public String palindromeReverse(@RequestParam(name = "phrase") String phrase, Model model) {
		model.addAttribute("phrase", phrase);
		model.addAttribute("isPalindrome", isPalindromeReverse(phrase));
		return "result";
	}

	@GetMapping("/palindrome/stream")
	public String palindromeStream(@RequestParam(name = "phrase") String phrase, Model model) {
		model.addAttribute("phrase", phrase);
		model.addAttribute("isPalindrome", isPalindromeStream(phrase));
		return "result";
	}

	@GetMapping("/palindrome/recursive")
	public String palindromeRecursive(@RequestParam(name = "phrase") String phrase, Model model) {
		model.addAttribute("phrase", phrase);
		model.addAttribute("isPalindrome", isPalindromeRecursive(phrase));
		return "result";
	}

	private boolean isPalindrome(String input) {
		if (input == null) return true;
		String clean = input.replaceAll("\\s+", "").toLowerCase();
		int forward = 0;
		int backward = clean.length()-1;
		while (backward > forward) {
			char forwardChar = clean.charAt(forward++);
			char backwardChar = clean.charAt(backward--);
			if (forwardChar != backwardChar) {
				return false;
			}
		}
		return true;
	}

	private static boolean isPalindromeReverse(String input) {
		if (input == null) return true;
		String clean = input.replaceAll("\\s+", "").toLowerCase();
		StringBuilder plain = new StringBuilder(clean);
		StringBuilder reverse = plain.reverse();
		return (reverse.toString()).equals(clean);
	}

	private static boolean isPalindromeStream(String input) {
		if (input == null) return true;
		String clean = input.replaceAll("\\s+", "").toLowerCase();
		return IntStream.range(0, clean.length()/2)
				.noneMatch(i -> clean.charAt(i) != clean.charAt(clean.length()-i-1));
	}

	private static boolean isPalindromeRecursive(String input) {
		if (input == null) return true;
		String clean = input.replaceAll("\\s+", "").toLowerCase();
		return recursivePalindrome(clean, 0, clean.length()-1);
	}

	private static boolean recursivePalindrome(String input, int forward, int backward) {
		if (forward == backward) {
			return true;
		}

		if (input.charAt(forward) != input.charAt(backward)) {
			return false;
		}

		if (forward < backward + 1) {
			return recursivePalindrome(input, forward+1, backward-1);
		}
		return true;
	}
}
