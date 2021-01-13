#!/bin/sh
echo "install/run/stop/info"
# shellcheck disable=SC2162
read ucmd
if [[ $ucmd = "i" ]] || [[ $ucmd = "install" ]]; then
  echo "start installing..."
  brew upgrade
  brew install nginx
  mkdir -p /usr/local/etc/nginx/www/html
elif [[ $ucmd = "r" ]] || [[ $ucmd = "run" ]]; then
  echo "starting nginx..."
  nginx
elif [[ $ucmd = "s" ]] || [[ $ucmd = "stop" ]]; then
  echo "stopping nginx..."
  nginx -s stop
  FILE=/usr/local/var/run/nginx.pid
  [ -f "$FILE" ] && nginx -s quit
elif [[ $ucmd = "i" ]] || [[ $ucmd = "info" ]]; then
  nginx -V
  echo "*****************************************"
  nginx -T
fi