echo "Create"
curl --request POST \
  --header "Content-Type: application/json" \
  --data '{"name":"fromCurl"}' \
  http://localhost:8080/
echo ""

echo "Delete"
curl --request DELETE \
  http://localhost:8080/1

echo "Fetch deleted"
curl http://localhost:8080/del/1
echo ""
