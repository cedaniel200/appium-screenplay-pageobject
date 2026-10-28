# Appium para arm64. La imagen oficial es solo amd64, así que la construimos sobre Node.
FROM node:22-bookworm-slim

RUN apt-get update \
    && apt-get install -y --no-install-recommends android-tools-adb ca-certificates \
    && rm -rf /var/lib/apt/lists/*

RUN npm install -g appium@3.9.0 \
    && appium driver install uiautomator2@8.7.2

# UiAutomator2 exige ANDROID_HOME para localizar adb.
RUN mkdir -p /opt/android/platform-tools \
    && ln -s /usr/bin/adb /opt/android/platform-tools/adb
ENV ANDROID_HOME=/opt/android
ENV ANDROID_SDK_ROOT=/opt/android

# El emulador vive en el host y se expone por adb sobre TCP.
ENV EMULATOR_HOST=host.docker.internal:5555

EXPOSE 4723

CMD ["sh", "-c", "adb connect ${EMULATOR_HOST} || true; appium --address 0.0.0.0 --port 4723"]
