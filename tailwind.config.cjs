/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/**/*.{astro,html,js,jsx,md,mdx,svelte,ts,tsx,vue}"],
  theme: {
    fontFamily: {
      dm: ["'DM Sans'", "sans-serif"],
      "dm-bold": ["'DM Sans Bold'", "sans-serif"],
    },
    colors: {
      transparent: "transparent",
      primary: "#2E323E",
      onPrimary: "#FFFFFF",
      secondary: "#565A66",
      onSecondary: "#FAFAD2",
      accent: "#81858F",
      onAccent: "#FFE4C4",
      background: "#17191E",
      onBackground: "#FFFFFF",
    },
    extend: {
      width: {
        page: "80vw",
      },
    },
  },
  plugins: [],
};
