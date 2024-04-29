package ru.gimadeev.springcourses;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static ru.gimadeev.springcourses.TelegramBotContent.*;

public class MainGame extends MultiSessionTelegramBot {
    public static final String NAME = "java_test_telegram2_bot"; // TODO: добавьте имя бота в кавычках
    public static final String TOKEN = "7025422172:AAEf0w47FTUDowkppqdRllNxnCek176Eohg"; //TODO: добавьте токен бота в кавычках

    public MainGame() {
        super(NAME, TOKEN);
    }

    int userGlory = getUserGlory();

    @Override
    public void onUpdateEventReceived(Update updateEvent) {
        if (getMessageText().equals("/start")) {
            if (!processedActions.contains("/start")) { // проверка на обработку команды /start
                sendPhotoMessageAsync("step_1_pic");
                sendTextMessageAsync(STEP_1_TEXT, Map.of("Взлом холодильника", "step_1_btn"));
                processedActions.add("/start"); // добавление команды /start в обработанные действия
            }

        }
        if (getMessageText().equals("/glory")) { // добавляем проверку на команду /glory
            int gloryPoints = getUserGlory(); // Получаем количество очков славы пользователя
            sendTextMessageAsync("Ваше количество очков славы: " + gloryPoints); // Отправляем пользователю количество очков славы
        }


        if (getCallbackQueryButtonKey().equals("step_1_btn")) {
            if (!processedActions.contains("step_1_btn")) {
                addUserGlory(20);
                userGlory = getUserGlory();
                sendPhotoMessageAsync("step_2_pic");
                sendTextMessageAsync("Вам добавлено 20 очков славы!"); // Уведомление о добавлении очков
                sendTextMessageAsync("Ваши текущие очки славы: " + userGlory);
                sendTextMessageAsync(STEP_2_TEXT,
                        Map.of("Взять сосиску! +20 славы", "step_2_btn",
                                "Взять рыбку! +20 славы", "step_2_btn",
                                "Скинуть банку с огурцами! +20 славы", "step_2_btn"));
                processedActions.add("step_1_btn");
            }
        }
        ///взломать робот - пылесос
        if (getCallbackQueryButtonKey().equals("step_2_btn")) {
            addUserGlory(20);
            userGlory = getUserGlory();
            sendPhotoMessageAsync("step_3_pic");
            sendTextMessageAsync("Вам добавлено 20 очков славы!"); // Уведомление о добавлении очков
            sendTextMessageAsync("Ваши текущие очки славы: " + userGlory);
            sendTextMessageAsync(STEP_3_TEXT,
                    Map.of("Взлом робота пылесоса", "step_3_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_3_btn")) {
            addUserGlory(30);
            userGlory = getUserGlory();
            sendPhotoMessageAsync("step_4_pic");
            sendTextMessageAsync("Вам добавлено 30 очков славы!"); // Уведомление о добавлении очков
            sendTextMessageAsync("Ваши текущие очки славы: " + userGlory);
            sendTextMessageAsync(STEP_4_TEXT,
                    Map.of("Отправить робот пылесос за едой! +30 славы", "step_4_btn",
                            "Покататься на роботе пылесосе! +30 славы", "step_4_btn",
                            "Убежать от робота пылесоса! +30 славы", "step_4_btn"));
        }
        //взламываем камеру Go-Pro
        if (getCallbackQueryButtonKey().equals("step_4_btn")) {
            addUserGlory(30);
            userGlory = getUserGlory();
            sendPhotoMessageAsync("step_5_pic");
            sendTextMessageAsync("Вам добавлено 30 очков славы!"); // Уведомление о добавлении очков
            sendTextMessageAsync("Ваши текущие очки славы: " + userGlory);
            sendTextMessageAsync(STEP_5_TEXT,
                    Map.of("Надеть и включить GoPro!", "step_5_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_5_btn")) {
            addUserGlory(40);
            userGlory = getUserGlory();
            sendPhotoMessageAsync("step_6_pic");
            sendTextMessageAsync("Вам добавлено 40 очков славы!"); // Уведомление о добавлении очков
            sendTextMessageAsync("Ваши текущие очки славы: " + userGlory);
            sendTextMessageAsync(STEP_6_TEXT,
                    Map.of("Бегать по крышам, снимать на GoPro! +40 славы", "step_6_btn",
                            "С GoPro нападать на других котов из засады! +40 славы", "step_6_btn",
                            "С GoPro нападать на собак из засады! +40 славы", "step_6_btn"));
        }
        //взламываем компьютер
        if (getCallbackQueryButtonKey().equals("step_6_btn")) {
            addUserGlory(20);
            userGlory = getUserGlory();
            sendPhotoMessageAsync("step_7_pic");
            sendTextMessageAsync(STEP_7_TEXT,
                    Map.of("Взлом пароля!", "step_7_btn"));
        }
        //хвастаемся дворовым котам
        if (getCallbackQueryButtonKey().equals("step_7_btn")) {
            addUserGlory(20);
            userGlory = getUserGlory();
            sendPhotoMessageAsync("step_8_pic");
            sendTextMessageAsync("Вам добавлено 20 очков славы!"); // Уведомление о добавлении очков
            sendTextMessageAsync("Ваши текущие очки славы: " + userGlory);
            sendTextMessageAsync(STEP_8_TEXT,
                    Map.of("Выйти во двор!", "step_8_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_8_btn")) {
            addUserGlory(50);
            userGlory = getUserGlory();
            sendImageMessageAsync("C:\\Users\\polon\\Desktop\\student\\TelegramBotJava\\src\\main\\resources\\images\\final_pic.jpg");
            sendTextMessageAsync("Вам добавлено 50 очков славы!"); // Уведомление о добавлении очков
            sendTextMessageAsync("Ваши текущие очки славы: " + userGlory);
            sendTextMessageAsync(FINAL_TEXT);
        }
    }


    private static Set<String> processedActions = new HashSet<>();

        public static void main(String[] args) throws TelegramApiException {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new MainGame());
        }
    }
