@echo off
cd C:\postman

call newman run JiraSep.postman_collection.json -e QA_ServiceNowJira.postman_environment.json -g workspace.postman_globals.json -d jiradata.csv -r htmlextra

pause