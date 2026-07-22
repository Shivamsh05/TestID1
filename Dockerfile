# Base image with Java
FROM openjdk:17

# Install Maven
RUN apt-get update && apt-get install -y maven

# Install browsers (Chrome + ChromeDriver)
RUN apt-get install -y wget unzip curl \
    && wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb \
    && apt install -y ./google-chrome-stable_current_amd64.deb \
    && CHROME_VERSION=$(google-chrome --version | awk '{print $3}') \
    && wget https://chromedriver.storage.googleapis.com/$CHROME_VERSION/chromedriver_linux64.zip \
    && unzip chromedriver_linux64.zip -d /usr/local/bin

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Build project
RUN mvn clean install

# Default command (run tests)
CMD ["mvn", "test"]
