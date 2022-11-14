# Stage 2: spin up a mysql container
FROM mysql:5.7
# Add a database
#ENV MYSQL_DATABASE poll
# Add the content of the sql-scripts/ directory to your image
# All scripts in docker-entrypoint-initdb.d/ are automatically
# executed during container startup
COPY ./covibed.sql /docker-entrypoint-initdb.d/
