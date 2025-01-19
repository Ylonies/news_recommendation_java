CREATE TABLE IF NOT EXISTS articles (
                                        article_id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
                                        name text NOT NULL,
                                        description text NOT NULL,
                                        date text NOT NULL,
                                        link text NOT NULL,
                                        creation_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS websites (
                                        website_id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
                                        name text NOT NULL,
                                        url text
);

CREATE TABLE IF NOT EXISTS catalogs (
                                        catalog_id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
                                        name text NOT NULL
);

CREATE TABLE IF NOT EXISTS users (
                                     user_id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
                                     password text NOT NULL,
                                     name text NOT NULL
);

CREATE TABLE IF NOT EXISTS user_time (
                                         user_id UUID NOT NULL,
                                         time timestamp NOT NULL,
                                         PRIMARY KEY (user_id),
                                         CONSTRAINT user_time_user_id_fk FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE IF NOT EXISTS article_category (
                                                article_id UUID NOT NULL,
                                                catalog_id UUID NOT NULL,
                                                website_id UUID NOT NULL,
                                                PRIMARY KEY (article_id, catalog_id, website_id),
                                                CONSTRAINT article_category_article_id_fk FOREIGN KEY (article_id) REFERENCES articles (article_id),
                                                CONSTRAINT article_category_catalog_id_fk FOREIGN KEY (catalog_id) REFERENCES catalogs (catalog_id),
                                                CONSTRAINT article_category_website_id_fk FOREIGN KEY (website_id) REFERENCES websites (website_id)
);

CREATE TABLE IF NOT EXISTS user_catalog (
                                            user_id UUID NOT NULL,
                                            catalog_id UUID NOT NULL,
                                            PRIMARY KEY (user_id, catalog_id),
                                            CONSTRAINT user_catalog_user_id_fk FOREIGN KEY (user_id) REFERENCES users (user_id),
                                            CONSTRAINT user_catalog_catalog_id_fk FOREIGN KEY (catalog_id) REFERENCES catalogs (catalog_id)
);

CREATE TABLE IF NOT EXISTS user_website (
                                            website_id UUID,
                                            user_id UUID NOT NULL,
                                            url text,
                                            name text NOT NULL,
                                            PRIMARY KEY (website_id, user_id),
                                            CONSTRAINT user_website_user_id_fk FOREIGN KEY (user_id) REFERENCES users (user_id),
                                            CONSTRAINT user_website_website_id_fk FOREIGN KEY (website_id) REFERENCES websites (website_id) ON DELETE CASCADE
);
