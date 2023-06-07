package ru.bot.botExforma.ValuesDB;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name= "MessangeStory")

public class MessangeStory {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="users_seq")
    @SequenceGenerator(name="users_seq", sequenceName="SEQ_USER", allocationSize=1)
    @Column(name="chatId", updatable=false, nullable=false)


    private long chatId;
    private Timestamp DataMessange;

    public double getChatId() {
        return chatId;
    }

    public void setChatId(double chatId) {
        this.chatId = (long) chatId;
    }

    public Timestamp getDataMessange() {
        return DataMessange;
    }

    public void setDataMessange(Timestamp dataMessange) {
        DataMessange = dataMessange;
    }

    public String getTopic() {
        return Topic;
    }

    public void setTopic(String topic) {
        Topic = topic;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getTerm() {
        return Term;
    }

    public void setTerm(String term) {
        Term = term;
    }

    public String getMessange() {
        return Messange;
    }

    public void setMessange(String messange) {
        Messange = messange;
    }

    private String Topic;
    private String IdUser;
    private String Category;

    public String getIdUser() {
        return IdUser;
    }

    public void setIdUser(String idUser) {
        IdUser = idUser;
    }

    private String Term;

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    private String Messange;
    private String FIO;



}
