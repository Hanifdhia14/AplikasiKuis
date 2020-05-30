package com.example.apliaksikuis;

public class QuestionBank {

    private String textQuestions [] = {
            "1. Apa warna bendera Indonesia?",
            "2. Siapa presiden pertama Indonesia?",
            "3. Siapa presiden Indonesia sekarang?",
            "4. tahun berapa indonesia merdeka",

    };

  //   array of multiple choices for each question
    private String multipleChoices [][] = {
          {"Merah - Putih", "putih merah", "kuning", "hijau"},
          {"Soeharto", "jokowi", "SBY", "Ir.Soekarno"},
          {"Megawati", "Prabowo", "Bj Habibi", "Jokowi"},
          {"1999", "2020", "1945", "2010"}
  };

    private String mCorrectAnswers[] = {"Merah - Putih", "Ir.Soekarno", "Jokowi", "1945"};

    public int getLength() { return textQuestions.length; }

    public String getQuestion(int a) {
        String question = textQuestions[a];
        return question;
    }

    public String getChoices(int index, int num) {
        String choice0 = multipleChoices[index][num-1];
        return choice0;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }
}
