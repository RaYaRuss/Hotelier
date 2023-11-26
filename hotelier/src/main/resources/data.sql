INSERT INTO agencies (`id`, `name`)
VALUES
    (1, 'Geo World'),
    (2, 'Travel with us'),
    (3, 'Bohemia');

INSERT INTO users (`id`, `active`, `email`, `first_name`, `last_name`, `password`, `travel_agency_id`)
VALUES
    (1, 1, 'maria@example.com', 'Maria', 'Ivanova', '95c1933b8ffe84f085f2839899d1673260be58dbd9c2c787ac35515805502c996417596dae9a92880aaa50a046fc7151', 1),
    (2, 1, 'ivan@example.com', 'Ivan', 'Ivanov', '95c1933b8ffe84f085f2839899d1673260be58dbd9c2c787ac35515805502c996417596dae9a92880aaa50a046fc7151', 2);

INSERT INTO roles (`id`, `role`)
VALUES
    (1, 'ADMIN'),
    (2, 'USER');

INSERT INTO users_roles(`user_id`, `role_id`)
VALUES
    (1, 1),
    (1, 2),
    (2, 2);

    INSERT INTO hotel_chains (`id`, `name`)
VALUES
    (1, 'Best Western'),
    (2, 'Rosslyn'),
    (3, 'Ibis');


INSERT INTO hotels (`id`, `description`,`name`, `category`, `hotel_chain_id`)
VALUES
    (1, 'Very nice, renovated hotel for travellers.', 'Ibis Sofia','THREE', 3 ),
    (2, 'Amiral Hotel is 0.6 mi from the beach in Varna, overlooking the Marine Garden. It features accommodations with a restaurant, private parking, a fitness center and a bar.','Amiral Varna','FOUR', 1 ),
    (3, 'Rosslyn Dimyat Hotel Varna is located in the heart of Varna next to the Sea Garden, 500 metres from the Varna Beach and 1 km away from the city centre.', 'Dimyat Varna','FOUR', 2 ),
    (4, 'This hotel provides free Wi-Fi, soundproof rooms, a 24-hour bistro bar and underground parking. It is in Berlin''s lively Prenzlauer Berg district, a 10-minute walk from Alexanderplatz.', 'Ibis Berlin','TWO', 3 ),
    (5, 'Rosslyn Central Park Hotel enjoys a central location on the famous pedestrian Vitosha Boulevard, lined with trendy coffees, restaurants, artisan shops and boutiques.', 'Central Park Sofia','FIVE', 2 );

-- INSERT INTO offers (`id`, `description`, `image_url`, `nights_count`, `price`, `room_type`, `start_date`, `uuid`, `hotel_id`, seller_id )
-- VALUES
--     (1, 'Hotel Near Sofia Airport', 'C:\Users\MacBookAir\Desktop\SpringAdvanced-Oct-2023\hotelier\src\main\resources\static\img\hotelPics\ibisSofia.jpg', 3, 150, DOUBLE,  22/12/2023, 'b72e6550-e365-43bf-aab2-b57cafc2db7c', 1, 1),
--     (2, 'Near Sea Garden Varna', 'C:\Users\MacBookAir\Desktop\SpringAdvanced-Oct-2023\hotelier\src\main\resources\static\img\hotelPics\amiral.jpg', 4, 200, STUDIO,  23/01/2024, 'b72e6550-e365-43bf-aab2-b57cafc2db71', 2, 2),
--     (3, 'Downtown Varna', 'C:\Users\MacBookAir\Desktop\SpringAdvanced-Oct-2023\hotelier\src\main\resources\static\img\hotelPics\dimyat.jpg', 2, 120, SINGLE, 14/02/2024, 'b72e6550-e365-43bf-aab2-b57cafc2db72', 3, 1),
--     (4, 'Top hotel in Berlin city Center', 'C:\Users\MacBookAir\Desktop\SpringAdvanced-Oct-2023\hotelier\src\main\resources\static\img\hotelPics\ibisBerlin.jpg', 5, 190, SINGLE, 03/01/2024, 'b72e6550-e365-43bf-aab2-b57cafc2db73', 4, 2),
--     (5, 'One of the best City Hotels', 'C:\Users\MacBookAir\Desktop\SpringAdvanced-Oct-2023\hotelier\src\main\resources\static\img\hotelPics\centralParkSofia.jpg', 1, 240, DOUBLE,  04/02/2024, 'b72e6550-e365-43bf-aab2-b57cafc2db74', 5, 1);