
/*
 * Copyright 2024 Vitaliy Zarubin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/**
 * SPDX-FileCopyrightText: Copyright 2023 Open Mobile Platform LLC <community@omp.ru>
 * SPDX-License-Identifier: BSD-3-Clause
 */
import QtQuick 2.0
import Sailfish.Silica 1.0

Page {
    id: root

    function fetchHelloWorld() {

        // send query
        shared.run(//"shared.my.company.name.ServiceRequestReact.getEvent.repos()",
                   "shared.com.example.kmpblank.ServiceRequestReact.getEvent.getHelloWorld()",
                   function (response) {
                       console.log(response)
                       helloText.text = response.toString()
                   }, function (error) {
                       console.log("error with message " + error)
                   })
    }

    function fetchDelayedHelloWorld() {

        // send query
        shared.run("shared.com.example.kmpblank.ServiceRequestReact.getEvent.getDelayedHelloWorld()",
                   function (response) {
                       console.log(response)
                       delayedHelloText.text = response.toString()
                   }, function (error) {
                       console.log("error with message " + error)
                   })
    }

    allowedOrientations: Orientation.All

    Column {
        anchors.centerIn: parent

        Text {
            id: helloText
            wrapMode: Text.WordWrap
            color: Theme.primaryColor
            textFormat: Text.StyledText
            horizontalAlignment: Qt.AlignCenter
            font.pixelSize: Theme.fontSizeLarge
        }

        Text {
            id: delayedHelloText
            wrapMode: Text.WordWrap
            color: Theme.primaryColor
            textFormat: Text.StyledText
            horizontalAlignment: Qt.AlignCenter
            font.pixelSize: Theme.fontSizeLarge
        }
    }

    Component.onCompleted: {
        root.fetchHelloWorld()
        root.fetchDelayedHelloWorld()
    }
}
