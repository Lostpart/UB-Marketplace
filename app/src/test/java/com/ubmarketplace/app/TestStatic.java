package com.ubmarketplace.app;

import com.ubmarketplace.app.model.Image;

public class TestStatic {
    final static public Long TEST_CURRENT_TIME = 1635051672000L;

    final static public String TEST_USER_NAME_1 = "UnitTest_TestUser1@test.com";
    final static public String TEST_PASSWORD_1 = "0a446a38175032f569a8c63dfb7ca4a1a82a7a072cb22b8e5ae58d77447cec44"; //Before hash: GoodPassword
    final static public String TEST_USER_NAME_2 = "UnitTest_TestUser2@test.com";
    final static public String TEST_PASSWORD_2 = "02a8cfdc38de40f29ca5b3a680b2eb1affd7bd370f86807219a0574b576fd7e4"; //Before hash: GoodPassword2
    final static public String TEST_USER_NAME_3 = "UnitTest_TestUser3@test.com";
    final static public String TEST_PASSWORD_3 = "70a44f128682264f16d291c6ff938974f6534f098c173278d940d43d71b45c84"; //Before hash: GoodPassword3
    final static public String TEST_ALWAYS_WRONG_PASSWORD = "ac606172c5011f97569a0b7960ae344e7d76d7b93eee312839b44694ccebcadd"; //Before hash: BadPassword

    final static public String TEST_ITEM_ID_1 = "55188c206c4e44e6977f75631a55c047";
    final static public String TEST_ITEM_NAME_1 = "UnitTest_TestItem1";
    final static public String TEST_ITEM_ID_2 = "68c8cd3624f94fd684c3ca7899731403";
    final static public String TEST_ITEM_NAME_2 = "UnitTest_TestItem2";
    final static public String TEST_ITEM_ID_3 = "7b686b06e46b41c6998a1c120b966365";
    final static public String TEST_ITEM_NAME_3 = "UnitTest_TestItem3";
    final static public String TEST_ITEM_DESCRIPTION_3 = "Laptop";
    final static public Double TEST_ITEM_PRICE_3 = 150.0;
    final static public String TEST_ITEM_IMAGE_3 = "https://cdn.pixabay.com/photo/2014/05/02/21/49/laptop-336373_1280.jpg";
    final static public String TEST_ITEM_MEETING_PLACE_3 = "Student Union";

    final static public String TEST_IMAGE_IMAGE_ID_1 = "IMGTestId01";
    final static public String TEST_IMAGE_THUMB_1 = "https://i.ibb.co/vmqm7fP/41bdffe1324e.png"; // Sample Image
    final static public String TEST_IMAGE_MEDIUM_1 = "https://i.ibb.co/5v4vNC8/41bdffe1324e.png"; // Sample Image
    final static public String TEST_IMAGE_LARGE_1 = "https://i.ibb.co/Cv8vk47/41bdffe1324e.png"; // Sample Image
    final static public String TEST_IMAGE_UPLOAD_BY_1 = "UnitTest@test.com";
    final static public Long TEST_IMAGE_UPLOAD_TIME_1 = TEST_CURRENT_TIME;
    final static public Image TEST_IMAGE_1 = new Image(TEST_IMAGE_IMAGE_ID_1, TEST_IMAGE_THUMB_1, TEST_IMAGE_MEDIUM_1,
            TEST_IMAGE_LARGE_1, TEST_IMAGE_UPLOAD_BY_1, TEST_IMAGE_UPLOAD_TIME_1);

    final static public String TEST_IMAGE_IMAGE_ID_2 = "IMGTestId02";
    final static public String TEST_IMAGE_THUMB_2 = "https://i.ibb.co/k3gXJDJ/linkedin-banner-image-2.png"; // Sample Image 2
    final static public String TEST_IMAGE_MEDIUM_2 = "https://i.ibb.co/jVvDzwz/linkedin-banner-image-2.png"; // Sample Image 2
    final static public String TEST_IMAGE_LARGE_2 = "https://i.ibb.co/GsvR9M9/linkedin-banner-image-2.png"; // Sample Image 2
    final static public String TEST_IMAGE_UPLOAD_BY_2 = "UnitTest@test.com";
    final static public Long TEST_IMAGE_UPLOAD_TIME_2 = TEST_CURRENT_TIME;
    final static public Image TEST_IMAGE_2 = new Image(TEST_IMAGE_IMAGE_ID_2, TEST_IMAGE_THUMB_2, TEST_IMAGE_MEDIUM_2,
            TEST_IMAGE_LARGE_2, TEST_IMAGE_UPLOAD_BY_2, TEST_IMAGE_UPLOAD_TIME_2);

    final static public String TEST_IMAGE_IMAGE_ID_INVALID = "BadImageId";

    final static public String TEST_MONGO_URL = "mongodb://%s:%d";
    final static public String TEST_MONGO_DATABASE_NAME = "UnitTest_Database";

    final static public String TEST_IMAGE_BASE64 = "/9j/4AAQSkZJRgABAQEAYABgAAD//gAUU29mdHdhcmU6IFNuaXBhc3Rl/9sAQwAD" +
            "AgIDAgIDAwMDBAMDBAUIBQUEBAUKBwcGCAwKDAwLCgsLDQ4SEA0OEQ4LCxAWEBETFBUVFQwPFxgWFBgSFBUU/9sAQwEDBAQFBAUJBQU" +
            "JFA0LDRQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQU/8AAEQgAJgBZAwEiAAIRAQMRAf/EAB" +
            "8AAAEFAQEBAQEBAAAAAAAAAAABAgMEBQYHCAkKC//EALUQAAIBAwMCBAMFBQQEAAABfQECAwAEEQUSITFBBhNRYQcicRQygZGhCCNCs" +
            "cEVUtHwJDNicoIJChYXGBkaJSYnKCkqNDU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6g4SFhoeIiYqSk5SVlpeY" +
            "mZqio6Slpqeoqaqys7S1tre4ubrCw8TFxsfIycrS09TV1tfY2drh4uPk5ebn6Onq8fLz9PX29/j5+v/EAB8BAAMBAQEBAQEBAQEAAAA" +
            "AAAABAgMEBQYHCAkKC//EALURAAIBAgQEAwQHBQQEAAECdwABAgMRBAUhMQYSQVEHYXETIjKBCBRCkaGxwQkjM1LwFWJy0QoWJDThJf" +
            "EXGBkaJicoKSo1Njc4OTpDREVGR0hJSlNUVVZXWFlaY2RlZmdoaWpzdHV2d3h5eoKDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKzt" +
            "LW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uLj5OXm5+jp6vLz9PX29/j5+v/aAAwDAQACEQMRAD8A/VOiivEvi9+0Trnwp8ZaNoSfCrxB" +
            "4kg1u9TTtK1LT9R06OK8uWheYxBZrhHQhY5PmdVX5eCcjKvql3HbRvse20Vh6d4qt3s9EGsLH4d1nVIVdNGvrqE3CS7NzxDY7LIycgl" +
            "Cw4yCRzVy68QaXZara6ZcalZwaldKWt7OWdFmmA6lEJywHfAqmrOwvM0KK8d079qXwjrWtrpenR3d3MPGDeC5WQwlUuhayXPnfLIT5J" +
            "WMgE4YnPy8V6VbeMtAvTMLfXNNnMNsLyQRXcbbIDnErYPCHB+Y8cdalNOPN0/4Cf5NMdmnb+t7fmjYorPtvEGl3mjjVrfUrOfSjGZRf" +
            "Rzo0BQdW3g7ce+aTS/Eek65B52m6pZahD5Sz+Za3CSr5bbgr5Un5TsbB6HafQ0xbmjRWbpXiXSNdCHTdVstQDhyptbhJdwRgrkbSc7W" +
            "IB9CQDUmm65pusvdJp+oWt89rL5NwttMshhkxnY+CdrYI4PNAF6iiigArwj9pSNpPH/wBCKWI8dAkAZ4Gm3xJr3eihfFGXZp/cPo13T" +
            "X3qx+ffxlgsT8UfjLp/xC134eeHrvWLhI9Fn8b6JPc6i+nfY4VhbS5UmTdsmEzBIQZFn3EjLKSzxdfeD/AAV8QotVm1Hw58VfGGozaH" +
            "DrHg3xZ4eltPEU91FFDEl5pbSp5yj7sxiZGjB80iSPLV+g9FFL93y+Vvnb/Pr96d0hTbnza73/AK9F0XytZs+C/DegaZo3xAZtP060s" +
            "Wb493ETNbQLGSi6NOVU4A4BZsDtuPrWX4E+C/gO6+Bn7KF7J4P0U3mqa/bx6jcLZRq98klleSyJOwGZUd4YmZXyD5a5HFfoRRSp/u0l" +
            "25f/ACW352Kk1NNPrzfjf8r/AIdD8+fFHhzRPCnxn8b6VeaXb2nwZ0n4h6XqPiLR4LQHToFn0LKzzwgbBB9rMEkmV2A4dsbSayvEFr4" +
            "T1zxb8eLj4Y6Z5vgW5j8G3msxeHLRjb6lpwvrk6i1rHGAJI2hWQP5QZXKzdSzV+jdYXjfwq3jTwzeaQmtat4dln2lNT0S4EF3bsrBgy" +
            "MysvUYKsrKQSCCDRG8FHrZW9fh37r3Vp206Ibale2l/wALXenZtt697PufC/jWbwN4l+Jfj2b9nW20xtdn+FWp2rXvgy3VIZp1ubcRx" +
            "wmIKjXCIzD5TvG6IHGFrrP2dl8Mar8Z/Bd14R8W/DhJdO0q7tb3Rfh/4cura5mtmjQiLUG81xB5cqoyi4VW371HzMwr6T+HnwaXwZ4o" +
            "1DxRq/ivXPHHii8tE0/+1NcFrGbe1Vy4hhitoIY0UsdzHaWYgZbAAHo1XG0LP+vt6envfeYvmlddP+BFff7v3BRRRUlhRRRQAUUUUAF" +
            "FFFABRRRQAUUUUAFFFFAH/9k=";

}