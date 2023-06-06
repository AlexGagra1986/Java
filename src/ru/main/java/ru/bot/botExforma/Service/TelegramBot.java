package ru.bot.botExforma.Service;





import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.bot.botExforma.Config.BotConfig;
import ru.bot.botExforma.Repository.MessangeStoryRepository;
import ru.bot.botExforma.Repository.UserRepository;
import ru.bot.botExforma.ValuesDB.MessangeStory;
import ru.bot.botExforma.ValuesDB.User;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class TelegramBot extends TelegramLongPollingBot {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MessangeStoryRepository messangeStoryRepository;

    String[] names = new String[2];
    private String cheak = "";
    private String step1 = "";
    private String step2 = "";
    private String step3 = "";

    private String UserName = "";

    private String Discription = "";
    final BotConfig config;
    final static String HELP_TEXT = "Это бот идей корпорации Эксформа.\n\n" + "Commands bot:\n\n" +
            "Выбрав /start вы начнете общение с ботом\n\n" +
            "Выбрав /clean вы очистите  чат с ботом\n\n" +
            "Выбрав /help вы получите информацию о боте";

    public TelegramBot(BotConfig config) {
        this.config = config;
        List<BotCommand> listOfCommands = new ArrayList<>();
        listOfCommands.add(new BotCommand("/start", "Команда начало бота"));
        listOfCommands.add(new BotCommand("/clean", "Очистить чат"));
        listOfCommands.add(new BotCommand("/help", "Помощь"));
        try {
            this.execute(new SetMyCommands(listOfCommands, new BotCommandScopeDefault(), null));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return config.getBotName();
    }

    @Override
    public String getBotToken() {
        return config.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {



        if (update.hasMessage() && update.getMessage().hasText()) {
            String messangeText = update.getMessage().getText();
            Long chatid = update.getMessage().getChatId();
            if(chatid==update.getMessage().getChatId()){
                switch (messangeText) {

                    case "/start":


                        startCommandReceived(chatid, update.getMessage().getChat().getFirstName());

// проверка
                        beginBotCommunicate(chatid);

                        cheak = "end";
                        break;

                    case "/clean":


                        break;
                    case "/help":
                        sendMessange(chatid, HELP_TEXT);
                        break;
                    default:
                        switch (cheak) {
                            case "end":
                                UserName = "";
                                UserName = update.getMessage().getText();

                                registerUser(update.getMessage());

                                cheak = "idea";
                                idea(chatid);//Введите Идею;
                                break;

                            case "idea":
                                Discription = "";
                                Discription = update.getMessage().getText();

                                registerMessange(update.getMessage());
                                cheak = "off";
                                //break;

                            case "off":
                                endCommandReceived(chatid);
                                break;
                        }
                }
            }


        } else if (update.hasCallbackQuery()) {
            String callbackData = update.getCallbackQuery().getData();
            long messangeId = update.getCallbackQuery().getMessage().getMessageId();
            long chatId = update.getCallbackQuery().getMessage().getChatId();

            if (callbackData.equals("Производство")) {
                String text = "Производство";
                EditMessageText messageText = new EditMessageText();

                messageText.setChatId(chatId);
                messageText.setText(text);
                messageText.setMessageId((int) messangeId);
                step1 = "Производство";
                try {
                    execute(messageText);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                mediumBotCommunicate(chatId);
            } else if (callbackData.equals("Продажи")) {
                String text = "Продажи";
                EditMessageText messageText = new EditMessageText();
                messageText.setChatId(chatId);
                messageText.setText(text);
                messageText.setMessageId((int) messangeId);
                step1 = "Продажи";
                try {
                    execute(messageText);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                mediumBotCommunicate(chatId);
            } else if (callbackData.equals("Обучение")) {
                String text = "Обучение";
                EditMessageText messageText = new EditMessageText();
                messageText.setChatId(chatId);
                messageText.setText(text);
                messageText.setMessageId((int) messangeId);
                step1 = "Обучение";
                try {
                    execute(messageText);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                mediumBotCommunicate(chatId);
            } else if (callbackData.equals("Подбор")) {
                String text = "Подбор";
                EditMessageText messageText = new EditMessageText();
                messageText.setChatId(chatId);
                messageText.setText(text);
                messageText.setMessageId((int) messangeId);
                step1 = "Подбор";
                try {
                    execute(messageText);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                mediumBotCommunicate(chatId);
            } else if (callbackData.equals("Планирование")) {
                String text = "Планирование";
                EditMessageText messageText = new EditMessageText();
                messageText.setChatId(chatId);
                messageText.setText(text);
                messageText.setMessageId((int) messangeId);
                step1 = "Планирование";
                try {

                    execute(messageText);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                mediumBotCommunicate(chatId);
            } else if (callbackData.equals("Оплата труда")) {
                String text = "Оплата труда";
                EditMessageText messageText = new EditMessageText();
                messageText.setChatId(chatId);
                messageText.setText(text);
                messageText.setMessageId((int) messangeId);
                step1 = "Оплата труда";
                try {
                    execute(messageText);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                mediumBotCommunicate(chatId);
            } else if (callbackData.equals("Новые направления")) {
                String text = "Новые направления";
                EditMessageText messageText = new EditMessageText();
                messageText.setChatId(chatId);
                messageText.setText(text);
                messageText.setMessageId((int) messangeId);
                step1 = "Новые направления";
                try {
                    execute(messageText);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                mediumBotCommunicate(chatId);
            } else if (callbackData.equals("IT")) {
                String text = "IT";
                EditMessageText messageText = new EditMessageText();
                messageText.setChatId(chatId);
                messageText.setText(text);
                messageText.setMessageId((int) messangeId);
                step1 = "IT";
                try {
                    execute(messageText);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                mediumBotCommunicate(chatId);
            } else if (callbackData.equals("Прочее")) {
                String text = "Прочее";
                EditMessageText messageText = new EditMessageText();
                messageText.setChatId(chatId);
                messageText.setText(text);
                messageText.setMessageId((int) messangeId);
                step1 = "Прочее";
                try {
                    execute(messageText);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                mediumBotCommunicate(chatId);

            } else if (callbackData.equals("Идея-мысль")) {
                String text = "Идея-мысль";
                EditMessageText messageText = new EditMessageText();
                messageText.setChatId(chatId);
                messageText.setText(text);
                messageText.setMessageId((int) messangeId);
                step2 = "Идея-мысль";
                try {
                    execute(messageText);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

                endComunicate(chatId);
            } else if (callbackData.equals("Долгосрочная цель")) {
                String text = "Долгосрочная цель";
                EditMessageText messageText = new EditMessageText();
                messageText.setChatId(chatId);
                messageText.setText(text);
                messageText.setMessageId((int) messangeId);
                step2 = "Долгосрочная цель";
                try {
                    execute(messageText);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                endComunicate(chatId);
            } else if (callbackData.equals("Краткосрочная цель")) {
                String text = "Краткосрочная цель";
                EditMessageText messageText = new EditMessageText();
                messageText.setChatId(chatId);
                messageText.setText(text);
                messageText.setMessageId((int) messangeId);
                step2 = "Краткосрочная цель";
                try {
                    execute(messageText);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                endComunicate(chatId);
            } else if (callbackData.equals("Конкретная задача")) {
                String text = "Конкретная задача";
                EditMessageText messageText = new EditMessageText();
                messageText.setChatId(chatId);
                messageText.setText(text);
                messageText.setMessageId((int) messangeId);
                step2 = "Конкретная задача";
                try {
                    execute(messageText);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                endComunicate(chatId);
            } else if (callbackData.equals("В рамках недели")) {
                String text = "В рамках недели";
                EditMessageText messageText = new EditMessageText();
                messageText.setChatId(chatId);
                messageText.setText(text);
                messageText.setMessageId((int) messangeId);
                step3 = "В рамках недели";
                try {
                    execute(messageText);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                insertName(chatId);
                cheak = "end";
            } else if (callbackData.equals("В рамках месяца")) {
                String text = "В рамках месяца";
                EditMessageText messageText = new EditMessageText();
                messageText.setChatId(chatId);
                messageText.setText(text);
                messageText.setMessageId((int) messangeId);
                step3 = "В рамках месяца";
                try {
                    execute(messageText);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                insertName(chatId);
                cheak = "end";
            } else if (callbackData.equals("В рамках квартала")) {
                String text = "В рамках квартала";
                EditMessageText messageText = new EditMessageText();
                messageText.setChatId(chatId);
                messageText.setText(text);
                messageText.setMessageId((int) messangeId);
                step3 = "В рамках квартала";

                try {
                    execute(messageText);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

                insertName(chatId);
                cheak = "end";
            } else if (callbackData.equals("В рамках года")) {
                String text = "В рамках года";
                EditMessageText messageText = new EditMessageText();
                messageText.setChatId(chatId);
                messageText.setText(text);
                messageText.setMessageId((int) messangeId);
                step3 = "В рамках года";
                try {
                    execute(messageText);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                insertName(chatId);
                cheak = "end";
            } else if (callbackData.equals("Более года или без срока")) {
                String text = "Более года или без срока";
                EditMessageText messageText = new EditMessageText();
                messageText.setChatId(chatId);
                messageText.setText(text);
                messageText.setMessageId((int) messangeId);
                step3 = "Более года или без срока";
                try {
                    execute(messageText);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

                insertName(chatId);

                cheak = "end";

            }

        }

    }




    private void registerMessange(Message messange){



        var idUser = messange.getChatId();
        MessangeStory messangeStory = new MessangeStory();
        messangeStory.setDataMessange(new Timestamp(System.currentTimeMillis()));
        messangeStory.setCategory(step1);
        messangeStory.setTerm(step2);
        messangeStory.setTopic(step3);
        messangeStory.setMessange(Discription);
        messangeStory.setFIO(UserName);
        messangeStory.getChatId();
        messangeStory.setIdUser(String.valueOf(idUser));
        messangeStoryRepository.save(messangeStory);

    }




    private void registerUser(Message message) {
        if(userRepository.findById(message.getChatId()).isEmpty()){
            User user = new User();
            var chatId = message.getChatId();
            var chat = message.getChat();

            user.setChatId(chatId);
            user.setFirstName(chat.getFirstName());
            user.setLastName(chat.getLastName());
            user.setUserName(UserName);
            user.setRegistredAt(new Timestamp(System.currentTimeMillis()));

            userRepository.save(user);

        }
    }


    private void endComunicate(long chatId){
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("-Когда реализуем?:");

        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();


        List<InlineKeyboardButton>rowInLine1 = new ArrayList<>();
        List<InlineKeyboardButton>rowInLine2 = new ArrayList<>();
        List<InlineKeyboardButton>rowInLine3 = new ArrayList<>();
        List<InlineKeyboardButton>rowInLine4 = new ArrayList<>();
        List<InlineKeyboardButton>rowInLine5 = new ArrayList<>();

        var button1 = new InlineKeyboardButton();
        button1.setText("В рамках недели");
        button1.setCallbackData("В рамках недели");

        var button2 = new InlineKeyboardButton();
        button2.setText("В рамках месяца");
        button2.setCallbackData("В рамках месяца");

        var button3 = new InlineKeyboardButton();
        button3.setText("В рамках квартала");
        button3.setCallbackData("В рамках квартала");

        var button4 = new InlineKeyboardButton();
        button4.setText("В рамках года");
        button4.setCallbackData("В рамках года");

        var button5 = new InlineKeyboardButton();
        button5.setText("Более года или без срока");
        button5.setCallbackData("Более года или без срока");

        rowInLine1.add(button1);
        rowInLine2.add(button2);
        rowInLine3.add(button3);
        rowInLine4.add(button4);
        rowInLine5.add(button5);


        rowsInLine.add(rowInLine1);
        rowsInLine.add(rowInLine2);
        rowsInLine.add(rowInLine3);
        rowsInLine.add(rowInLine4);
        rowsInLine.add(rowInLine5);

        markup.setKeyboard(rowsInLine);

        message.setReplyMarkup(markup);

        try {
            execute(message);
        }catch (TelegramApiException e){
            e.printStackTrace();
        }

    }
    private void mediumBotCommunicate(long chatId){
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("-Масштаб идеи:");

        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();


        List<InlineKeyboardButton>rowInLine1 = new ArrayList<>();
        List<InlineKeyboardButton>rowInLine2 = new ArrayList<>();
        List<InlineKeyboardButton>rowInLine3 = new ArrayList<>();
        List<InlineKeyboardButton>rowInLine4 = new ArrayList<>();


        var button1 = new InlineKeyboardButton();
        button1.setText("Идея-мысль");
        button1.setCallbackData("Идея-мысль");

        var button2 = new InlineKeyboardButton();
        button2.setText("Долгосрочная цель");
        button2.setCallbackData("Долгосрочная цель");

        var button3 = new InlineKeyboardButton();
        button3.setText("Краткосрочная цель");
        button3.setCallbackData("Краткосрочная цель");

        var button4 = new InlineKeyboardButton();
        button4.setText("Конкретная задача");
        button4.setCallbackData("Конкретная задача");


        rowInLine1.add(button1);
        rowInLine2.add(button2);
        rowInLine3.add(button3);
        rowInLine4.add(button4);


        rowsInLine.add(rowInLine1);
        rowsInLine.add(rowInLine2);
        rowsInLine.add(rowInLine3);
        rowsInLine.add(rowInLine4);

        markup.setKeyboard(rowsInLine);

        message.setReplyMarkup(markup);

        try {
            execute(message);
        }catch (TelegramApiException e){
            e.printStackTrace();
        }

    }




    private void beginBotCommunicate(long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("- О чём думаете?:");

        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();

        List<InlineKeyboardButton>rowInLine1 = new ArrayList<>();
        List<InlineKeyboardButton>rowInLine2 = new ArrayList<>();
        List<InlineKeyboardButton>rowInLine3 = new ArrayList<>();
        List<InlineKeyboardButton>rowInLine4 = new ArrayList<>();
        List<InlineKeyboardButton>rowInLine5 = new ArrayList<>();
        List<InlineKeyboardButton>rowInLine6 = new ArrayList<>();
        List<InlineKeyboardButton>rowInLine7 = new ArrayList<>();
        List<InlineKeyboardButton>rowInLine8 = new ArrayList<>();
        List<InlineKeyboardButton>rowInLine9 = new ArrayList<>();

        var button1 = new InlineKeyboardButton();
        button1.setText("Производство");
        button1.setCallbackData("Производство");

        var button2 = new InlineKeyboardButton();
        button2.setText("Продажи");
        button2.setCallbackData("Продажи");

        var button3 = new InlineKeyboardButton();
        button3.setText("Обучение");
        button3.setCallbackData("Обучение");

        var button4 = new InlineKeyboardButton();
        button4.setText("Подбор");
        button4.setCallbackData("Подбор");

        var button5 = new InlineKeyboardButton();
        button5.setText("Планирование");
        button5.setCallbackData("Планирование");

        var button6 = new InlineKeyboardButton();
        button6.setText("Оплата труда");
        button6.setCallbackData("Оплата труда");

        var button7 = new InlineKeyboardButton();
        button7.setText("Новые направления");
        button7.setCallbackData("Новые направления");

        var button8 = new InlineKeyboardButton();
        button8.setText("IT");
        button8.setCallbackData("IT");

        var button9 = new InlineKeyboardButton();
        button9.setText("Прочее");
        button9.setCallbackData("Прочее");

        rowInLine1.add(button1);
        rowInLine2.add(button2);
        rowInLine3.add(button3);
        rowInLine4.add(button4);
        rowInLine5.add(button5);
        rowInLine6.add(button6);
        rowInLine7.add(button7);
        rowInLine8.add(button8);
        rowInLine9.add(button9);

        rowsInLine.add(rowInLine1);
        rowsInLine.add(rowInLine2);
        rowsInLine.add(rowInLine3);
        rowsInLine.add(rowInLine4);
        rowsInLine.add(rowInLine5);
        rowsInLine.add(rowInLine6);
        rowsInLine.add(rowInLine7);
        rowsInLine.add(rowInLine8);
        rowsInLine.add(rowInLine9);

        markup.setKeyboard(rowsInLine);

        message.setReplyMarkup(markup);

        try {
            execute(message);
        }catch (TelegramApiException e){
            e.printStackTrace();
        }
    }

    private void startCommandReceived(Long chatId,String name){
        String answer = "- Рады приветствовать в банке идей компании «Экс-форма».\n\n"+
                "Мы строим мир, в котором будем жить!";

        sendMessange(chatId,answer);
    }
    private void idea(Long chatId){
        String answer = "Введите свою идею:";
        sendMessange(chatId,answer);
    }

    private void endCommandReceived(Long chatId){
        String answer = "Спасибо за вашу идею,\n\n"+"Для ввода еще одной идеи нажмите /start";

        sendMessange(chatId,answer);
    }
    private void insertName(Long chatId){
        String answer = "Введите свои ФИО :";
        sendMessange(chatId,answer);
    }


    private void sendMessange(Long chatId, String textToSend){
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);
        try {
            execute(message);
        }catch (TelegramApiException e){
            e.printStackTrace();
        }
    }




}
