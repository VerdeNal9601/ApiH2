package com.test.h2db.h2testbd.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")

public class UserDto implements Serializable {

        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_user")

        private Long idUser;
        private String name;
        private Integer age;


        @OneToMany(mappedBy = "userDto")
        private List<BookingDto> BookingDtoList;

        public UserDto() {
        }

        public UserDto(Long idUser, String name, String lastName, Integer age) {
                this.idUser = idUser;
                this.name = name;
                this.age = age;
        }

        public Long getIdUser() {
                return idUser;
        }

        public void setIdUser(Long idUser) {
                this.idUser = idUser;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public Integer getAge() {
                return age;
        }

        public void setAge(Integer age) {
                this.age = age;
        }

        @Override
        public String toString() {
                return "UserDto{" +
                        "idUser=" + idUser +
                        ", name='" + name + '\'' +
                        ", age=" + age +
                        '}';
        }
}

