package gui;

import java.io.*;
import java.nio.file.*;


public class BackendController {

    // =====================================================
    // PROCESS
    // =====================================================

    private static Process process;

    private static BufferedReader reader;

    private static BufferedWriter writer;


    // =====================================================
    // START BACKEND
    // =====================================================

    public static boolean startBackend() {

        try {

            // Already running

            if (
                    process != null
                    && process.isAlive()
            ) {

                return true;
            }


            // -------------------------------------------------
            // FIND PROJECT ROOT
            // -------------------------------------------------

            Path current =
                    Paths.get(
                            System.getProperty(
                                    "user.dir"
                            )
                    ).toAbsolutePath();


            Path projectRoot =
                    current;


            /*
             * If Java is started from java-gui,
             * move one level up to DS_project.
             */

            if (
                    current.getFileName()
                            .toString()
                            .equalsIgnoreCase(
                                    "java-gui"
                            )
            ) {

                projectRoot =
                        current.getParent();
            }


            // -------------------------------------------------
            // BACKEND PATH
            // -------------------------------------------------

            Path backendPath =
                    projectRoot
                            .resolve("c-backend")
                            .resolve(
                                    "hostel_backend.exe"
                            );


            if (
                    !Files.exists(
                            backendPath
                    )
            ) {

                System.out.println(
                        "Backend executable not found:"
                );

                System.out.println(
                        backendPath
                );

                return false;
            }


            // -------------------------------------------------
            // START PROCESS
            // -------------------------------------------------

            ProcessBuilder builder =
                    new ProcessBuilder(
                            backendPath.toString()
                    );


            /*
             * Important:
             *
             * C file handler uses:
             *
             * c-backend/data/students.txt
             *
             * Therefore backend must run from
             * DS_project root.
             */

            builder.directory(
                    projectRoot.toFile()
            );


            // Combine stdout + stderr

            builder.redirectErrorStream(
                    true
            );


            process =
                    builder.start();


            reader =
                    new BufferedReader(
                            new InputStreamReader(
                                    process.getInputStream()
                            )
                    );


            writer =
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    process.getOutputStream()
                            )
                    );


            // -------------------------------------------------
            // WAIT FOR READY
            // -------------------------------------------------

            String line;


            while (
                    (line = reader.readLine())
                            != null
            ) {

                System.out.println(
                        "C: " + line
                );


                if (
                        line.equals(
                                "READY|Backend started"
                        )
                ) {

                    System.out.println(
                            "C Backend started successfully."
                    );

                    return true;
                }
            }


            return false;
        }

        catch (
                IOException e
        ) {

            System.out.println(
                    "Backend start error: "
                    + e.getMessage()
            );

            return false;
        }
    }


    // =====================================================
    // SEND COMMAND
    // =====================================================

    private static String sendCommand(
            String command
    ) {

        try {

            // Start backend if necessary

            if (
                    process == null
                    || !process.isAlive()
            ) {

                boolean started =
                        startBackend();


                if (!started) {

                    return "ERROR|Backend could not start";
                }
            }


            // -------------------------------------------------
            // SEND COMMAND TO C
            // -------------------------------------------------

            writer.write(
                    command
            );

            writer.newLine();

            writer.flush();


            // -------------------------------------------------
            // READ RESPONSE
            // -------------------------------------------------

            String line;


            while (
                    (line = reader.readLine())
                            != null
            ) {

                System.out.println(
                        "C: " + line
                );


                /*
                 * These are the machine-readable
                 * responses we care about.
                 */

                if (
                        line.startsWith(
                                "SUCCESS|"
                        )
                        ||
                        line.startsWith(
                                "FOUND|"
                        )
                        ||
                        line.startsWith(
                                "NOT_FOUND|"
                        )
                        ||
                        line.startsWith(
                                "ERROR|"
                        )
                ) {

                    return line;
                }
            }


            return "ERROR|No response from backend";
        }

        catch (
                IOException e
        ) {

            return "ERROR|" + e.getMessage();
        }
    }


    // =====================================================
    // ADD STUDENT
    // =====================================================

    public static String addStudent(
            int studentID,
            String name,
            String department,
            int year,
            String room
    ) {

        String command =
                "ADD|"
                + studentID
                + "|"
                + name
                + "|"
                + department
                + "|"
                + year
                + "|"
                + room;


        return sendCommand(
                command
        );
    }


    // =====================================================
    // SEARCH STUDENT
    // =====================================================

    public static String searchStudent(
            int studentID
    ) {

        String command =
                "SEARCH|"
                + studentID;


        return sendCommand(
                command
        );
    }


    // =====================================================
    // UPDATE STUDENT
    // =====================================================

    public static String updateStudent(
            int studentID,
            String department,
            int year,
            String room
    ) {

        String command =
                "UPDATE|"
                + studentID
                + "|"
                + department
                + "|"
                + year
                + "|"
                + room;


        return sendCommand(
                command
        );
    }


    // =====================================================
    // DELETE STUDENT
    // =====================================================

    public static String deleteStudent(
            int studentID
    ) {

        String command =
                "DELETE|"
                + studentID;


        return sendCommand(
                command
        );
    }


    // =====================================================
    // SAVE DATA
    // =====================================================

    public static String saveData() {

        return sendCommand(
                "SAVE"
        );
    }


    // =====================================================
    // ROOM STATUS
    // =====================================================

    public static String getRoomStatus() {

        try {

            // Start backend if necessary

            if (
                    process == null
                    || !process.isAlive()
            ) {

                boolean started =
                        startBackend();


                if (!started) {

                    return "ERROR|Backend could not start";
                }
            }


            // -------------------------------------------------
            // SEND ROOMS COMMAND
            // -------------------------------------------------

            writer.write(
                    "ROOMS"
            );

            writer.newLine();

            writer.flush();


            // -------------------------------------------------
            // READ ROOM DATA
            // -------------------------------------------------

            StringBuilder result =
                    new StringBuilder();


            String line;


            while (
                    (line = reader.readLine())
                            != null
            ) {

                System.out.println(
                        "C: " + line
                );


                if (
                        line.equals(
                                "ROOMS_END"
                        )
                ) {

                    break;
                }


                result.append(
                        line
                );

                result.append(
                        "\n"
                );
            }


            return result.toString();
        }

        catch (
                IOException e
        ) {

            return "ERROR|" + e.getMessage();
        }
    }


    // =====================================================
    // LIVE STATISTICS
    // =====================================================

    public static String getStats() {

        try {

            // Start backend if necessary

            if (
                    process == null
                    || !process.isAlive()
            ) {

                boolean started =
                        startBackend();


                if (!started) {

                    return "ERROR|Backend could not start";
                }
            }


            // -------------------------------------------------
            // SEND STATS COMMAND
            // -------------------------------------------------

            writer.write(
                    "STATS"
            );

            writer.newLine();

            writer.flush();


            // -------------------------------------------------
            // READ STATS
            // -------------------------------------------------

            String result = null;


            String line;


            while (
                    (line = reader.readLine())
                            != null
            ) {

                System.out.println(
                        "C: " + line
                );


                if (
                        line.startsWith(
                                "STATS|"
                        )
                ) {

                    result =
                            line;
                }


                if (
                        line.equals(
                                "STATS_END"
                        )
                ) {

                    break;
                }
            }


            if (
                    result == null
            ) {

                return "ERROR|No statistics received";
            }


            return result;
        }

        catch (
                IOException e
        ) {

            return "ERROR|" + e.getMessage();
        }
    }


    // =====================================================
    // CLOSE BACKEND
    // =====================================================

    public static void closeBackend() {

        try {

            if (
                    process != null
                    && process.isAlive()
            ) {

                writer.write(
                        "EXIT"
                );

                writer.newLine();

                writer.flush();


                String line;


                while (
                        (line = reader.readLine())
                                != null
                ) {

                    System.out.println(
                            "C: " + line
                    );


                    if (
                            line.startsWith(
                                    "SUCCESS|Backend closed"
                            )
                    ) {

                        break;
                    }
                }
            }


            if (
                    writer != null
            ) {

                writer.close();
            }


            if (
                    reader != null
            ) {

                reader.close();
            }


            if (
                    process != null
            ) {

                process.destroy();
            }


            process = null;

            reader = null;

            writer = null;
        }

        catch (
                IOException e
        ) {

            System.out.println(
                    "Backend close error: "
                    + e.getMessage()
            );
        }
    }
}