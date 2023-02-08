INSERT IGNORE INTO user
    SET id              = 1,
        email_address   = 'internship@example.com',
        phone_number    = '09099999999',
        bank            = '福岡銀行',
        branch          = '本店営業部',
        account_type    = 1,
        account_number  = '9999999',
        created_at      = NOW(),
        updated_at      = NOW();