//
//  ContentView.swift
//  Findine
//
//  Created by Eason Feng on 2022-08-18.
//

import SwiftUI

struct ContentView: View {
    var body: some View{
        TabView {
            FindView()
                .tabItem() {
                    Image(systemName: "phone.fill")
                    Text("Find")
                }
            BrowseView()
                .tabItem() {
                    Image(systemName: "phone.fill")
                    Text("Browse")
                }
            SettingsView()
                .tabItem() {
                    Image(systemName: "phone.fill")
                    Text("Settings")
                }

        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}



