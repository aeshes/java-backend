#!/bin/bash

script='mutation {
    createLink(url: \"zzz\", description: \"fff\") {
        id
        url
        description
    }
}'

script="$(echo $script)"

echo "Creating new link. Executing query:"
echo "{ \"query\": \"$script\" }"

echo $(curl -s -X POST \
    -H "Content-Type: application/json" \
    -H "Authorization: Bearer 5cd9350f97ae601fc22a6157" \
    -d "{ \"query\": \"$script\" }" \
    http://localhost:8080/graphql)