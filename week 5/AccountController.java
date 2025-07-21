package com.example.account.controller;

import com.example.account_service.entity.Account;
import com.example.account_service.model.Loan;
import com.example.account_service.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account saved = accountRepository.save(account);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getAccountById(@PathVariable Long id) {
        Optional<Account> account = accountRepository.findById(id);

        if (account.isPresent()) {
           
            Loan loan = restTemplate.getForObject("http://localhost:8082/api/loans/1", Loan.class);

            Map<String, Object> response = new HashMap<>();
            response.put("account", account.get());
            response.put("loan", loan);

            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
