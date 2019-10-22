  create user dbwa with password 'awbdawbd' login nocreaterole;
  create user dbwl with password 'lwbdlwbd' login nocreaterole;
  create schema dbw;
  revoke all on schema public from dbwa;
  revoke all on schema public from dbwl;
  grant all on schema dbw to dbwl;
  grant usage on schema dbw to dbwa;

  SET search_path = dbw;

