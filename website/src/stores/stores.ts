import {configureStore} from "@reduxjs/toolkit";
import languageSlice from "./slices/languageSlice";

export const store = configureStore({
    reducer: {
        language: languageSlice
    }
})

export type RootType = ReturnType<typeof store.getState>;
export type AppDispatch = typeof store.dispatch;