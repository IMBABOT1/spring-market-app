create table products
(
    id         bigserial primary key,
    title      varchar(255),
    price      int
);


INSERT INTO products (title, price) VALUES
                                        ('Dark Souls', 80),
                                        ('Dark Souls2', 80),
                                        ('Dark Souls3', 80),
                                        ('Bloodborne', 80),
                                        ('Sekiro', 80),
                                        ('Elden Ring', 80),
                                        ('StarCraft', 80),
                                        ('World of Warcraft ', 80),
                                        ('World of Warcraft: Wrath of the Lich King', 80),
                                        ('StarCraft II', 80),
                                        ('StarCraft II Wings of Liberty', 80),
                                        ('StarCraft II: Heart of the Swarm', 80),
                                        ('StarCraft II: Legacy of the Void', 80),
                                        ('Dota', 80),
                                        ('Dota 2', 80),
                                        ('World of Warcraft: Burning Crusade', 80),
                                        ('World of Warcraft: Cataclysm', 80),
                                        ('World of Warcraft: Mists of Pandaria', 80),
                                        ('World of Warcraft: Warlords of Draenor', 80),
                                        ('Milk', 100),
                                        ('Bread', 80),
                                        ('Cheese', 90);