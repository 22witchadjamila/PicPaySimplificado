package com.picpaysimplificado.domain.transaction;

import com.picpaysimplificado.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name="transactions")
@Table(name="transactions")
@Getter // coming from lombok dependence
@Setter // coming from lombok dependence
@AllArgsConstructor // constructor that will receive all the classes parameters
@EqualsAndHashCode(of="Id")
@NoArgsConstructor

public class Transaction {
    @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long Id;
    private BigDecimal amount;// how much one user send to another
   @ManyToOne // Here I am just saying that one user one can have one sender and one receiver , but one user can make many transactions
   @JoinColumn(name="sender_id")
    private User sender;
    @ManyToOne
    @JoinColumn(name="receiver_id")
    private User receiver;
    private LocalDateTime timestamp;



}
