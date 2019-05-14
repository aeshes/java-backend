#!/bin/bash

curl \
    -X POST \
    -H "Content-Type: application/json" \
    --data '{ "query": "{ allLinks { url description postedBy { id name } }}" }' \
    http://localhost:8080/graphql