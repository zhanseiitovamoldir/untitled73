package com.company.addComponents;

import java.io.Serializable;

public class General implements Serializable {
        private Serializable data;
        private String code;


        public General(String code) {
            this.code = code;
        }

        public General(String code,Serializable data) {
            this.code = code;
            this.data = data;
        }

        public Serializable getData() {
            return data;
        }
        public void setData(Serializable data) {
            this.data = data;
        }
        public String getCode() {
            return code;
        }
        public void setCode(String code) {
            this.code = code;
        }
    }



