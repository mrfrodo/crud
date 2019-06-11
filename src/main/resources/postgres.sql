sudo -u postgres createuser --interactive
->gandalf

sudo -u postgres createdb gandalf

sudo adduser gandalf

#open db prompt to gandalf
sudo -u gandalf psql

#change password on gandalf
ALTER USER gandalf WITH PASSWORD 'gandalf';