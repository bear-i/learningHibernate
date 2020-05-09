create domain EMAIL_ADDRESS as varchar(255) check (position('@' in value) > 1);
