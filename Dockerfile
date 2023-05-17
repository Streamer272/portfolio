FROM httpd:latest

WORKDIR /usr/local/apache2/htdocs
COPY build .

COPY config/httpd.conf /home/portfolio-httpd.conf
RUN cat /home/portfolio-httpd.conf >> /usr/local/apache2/conf/httpd.conf

EXPOSE 80
CMD ["httpd-foreground"]
