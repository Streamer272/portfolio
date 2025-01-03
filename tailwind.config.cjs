/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/**/*.{astro,html,js,jsx,md,mdx,svelte,ts,tsx,vue}"],
  theme: {
    extend: {
      width: {
        page: "80vw",
      },
      fontFamily: {
        dm: ["'DM Sans'", "sans-serif"],
        "dm-bold": ["'DM Sans Bold'", "sans-serif"],
      },
      colors: {
        s1: "#171717",
        s2: "#424242",
        s3: "#4a4a4a",
        s4: "#b0bec5",
        t1: "#e5e5e5",
        t2: "#cccccc",
      },
    },
  },
  plugins: [],
};
