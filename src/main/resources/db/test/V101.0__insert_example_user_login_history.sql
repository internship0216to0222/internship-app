INSERT IGNORE INTO user_login_history
    SET id                 = 1,
        user_id            = 1,
        user_agent         = 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.212 Safari/537.36',
        source_ip_address  = '192.168.000.000',
        logged_in_at       = NOW(),
        created_at         = NOW(),
        updated_at         = NOW();
