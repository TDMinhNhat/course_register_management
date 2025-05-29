import {createBrowserRouter} from "react-router";
import LoginPage from "../pages/LoginPage.tsx";
import StudentPage from "../pages/StudentPage.tsx";
import TeacherPage from "../pages/TeacherPage.tsx";
import AdminPage from "../pages/AdminPage.tsx";

const routes = createBrowserRouter([
    {
        path: "/",
        element: <LoginPage />
    },
    {
        path: "/student",
        element: <StudentPage />
    },
    {
        path: "/teacher",
        element: <TeacherPage />
    },
    {
        path: "/admin",
        element: <AdminPage />
    }
])

export default routes;