import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import {RouterProvider} from "react-router";
import {Provider} from "react-redux";
import routes from "./routes/routes.tsx";
import "../node_modules/bootstrap/dist/css/bootstrap.css";
import "../node_modules/bootstrap/dist/js/bootstrap.js";
import {store} from "./stores/stores.ts";

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <Provider store={store}>
        <RouterProvider router={routes}>
        </RouterProvider>
    </Provider>
  </StrictMode>,
)
