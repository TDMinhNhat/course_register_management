import {createSlice} from "@reduxjs/toolkit";
import english from "../../languages/english.json";

export const languageSlice = createSlice({
    name: "language",
    initialState: english,
    reducers: {
        setLanguage: (_state, action) => {
            const chooseLanguage = action.payload;
            switch (chooseLanguage) {
                case "english": return english;
                default: return english;
            }
        }
    }
})

export const { setLanguage } = languageSlice.actions;
export default languageSlice.reducer;