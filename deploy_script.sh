#!/bin/bash

# Exit immediately if a command exits with a non-zero status
set -e

# Navigate to the directory of your application on the server
cd /path/to/your/application/on/server

# The following is an example set of commands you might run:

# Pull the latest changes from the repository
# git pull origin master

# Build your project, if necessary
# ./gradlew build

# Stop the current application, if necessary
# sudo systemctl stop my-application.service

# Copy new build artifacts from a directory where your CI pipeline has placed them
# For example, you might copy a JAR file to a specific location
# cp /path/to/artifact/my-application.jar /path/to/deployment/

# Start the application back up
# sudo systemctl start my-application.service

# Print a success message
echo "Deployment successful!"
