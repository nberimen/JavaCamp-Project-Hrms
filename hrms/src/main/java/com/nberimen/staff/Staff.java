package com.nberimen.staff;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

import com.nberimen.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="user_id", referencedColumnName = "id")
public class Staff extends User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
}
